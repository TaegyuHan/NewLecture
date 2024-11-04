package kr.co.rland.boot3.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            CorsConfigurationSource corsConfigurationSource
    ) throws Exception {

        // 인터럽트 URL
        http
        //.cors(AbstractHttpConfigurer::disable) // CORS 비활성화
        .cors(cors -> cors.configurationSource(corsConfigurationSource))
        .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화
        .authorizeHttpRequests(authorizeRequests -> // 요청에 대한 권한 설정
            authorizeRequests
                    .requestMatchers("/admin/**").authenticated()// /admin/** 경로는 인증 필요
                    .anyRequest().permitAll() // 나머지는 인증 필요 없음
        )
        // 인증 방식 설정
        .formLogin(formConfig ->
            formConfig
                .loginPage("/user/signin") // GET 로그인 페이지
                .loginProcessingUrl("/user/signin") // POST 로그인 처리 URL
                .successForwardUrl("/") // 이것은 고정으로 이동시키는 것

                // 로그인 성공 후 원하는 권한이나 상황에 따라서 처리할 수 있는 핸들러
//                .successHandler((request, response, authentication) -> {
//                    response.sendRedirect("/");
//                })
        );

        // SecurityContextHolder: SecurityContext를 제공하는 클래스
        // principal: 사용자 정보
        // credentials: 비밀번호
        // authorities: 권한

        // USerDetails -> UserDetailsService
        /*
        1. 메모리 유저
        2. JDBC 유저
        3. X.500 유저
        4. LDAP 유저
        */

        //CORS, CSRF

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.addAllowedHeader("*");
//        source.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source; //
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("newlec")
                .password("{noop}111")
                .roles("MEMBER", "ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("dragon")
                .password("{noop}111")
                .roles("MEMBER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}