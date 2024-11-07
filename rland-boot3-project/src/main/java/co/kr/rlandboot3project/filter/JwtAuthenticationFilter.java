package co.kr.rlandboot3project.filter;

import co.kr.rlandboot3project.anorymous.auth.RlandUserDetails;
import co.kr.rlandboot3project.anorymous.auth.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;
    // private UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 토큰에 있는 내용을 모두 꺼내서 그것만으로 인증을 완성할 것인지?
        String authHeader = request.getHeader("Authorization");
        // 인증 토큰을 가지고 있다면
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            // 토큰의 유효성을 검사하고
//            if (username != null && !username.isEmpty()) {
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username); // 이것을 사용하면 DB를 사용하게 된다.
//                // DB를 스캔 하는 이것이 비효율 적이면 JWT내용을 담아서 사용하는 것이 좋다.
//            }
            // 인증 정보를 담기
            // 토큰이 위조 되었는지 확인 해야 한다.
            if (jwtUtil.validateToken(token)) { // 인증 정보 유효성 검사
                // 사용자 정보를 꺼내서
                String username = jwtUtil.extractUsername(token);
                List<String> roles = jwtUtil.extractRoles(token);

                // 인증 정보를 담는다.
                if (username != null && !username.isEmpty()) {
                    // 사용자 정보 & role 데이터까지 로드 한 거임.
                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    for (String role : roles) { // 권한을 담아 주는 작업
                        authorities.add(new SimpleGrantedAuthority(role));
                    }

                    UserDetails userDetails = RlandUserDetails.builder()
                            // .id(member.getId())
                            .username(username)
                            // .password(member.getPwd())
                            // .email(member.getEmail())
                            .authorities(authorities)
                            .build();

                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    // JWT 토큰에 다른 필터에서 사용할 수 있도록 추가
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // 인증 정보를 담는다.
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        // 토큰에 있는 내용을 최소화하고 여기서 추가적인 인증을 완성할 건지?

        // 사전 처리
        filterChain.doFilter(request, response); // -> 인증 필터에게 전달.
        // 사후 처리

    }
}
