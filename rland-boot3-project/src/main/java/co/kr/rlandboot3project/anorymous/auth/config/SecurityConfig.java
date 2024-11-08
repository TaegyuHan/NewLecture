package co.kr.rlandboot3project.anorymous.auth.config;


import co.kr.rlandboot3project.anorymous.auth.util.JwtUtil;
import co.kr.rlandboot3project.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;


@Configuration
public class SecurityConfig {

//    @Autowired
//    private DataSource dataSource;

    private JwtUtil jwtUtil;

    public SecurityConfig(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            CorsConfigurationSource corsConfigurationSource) throws Exception {

        http
                .cors(cors->cors.configurationSource(corsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests
                        // 인터렙트 URL
                        -> authorizeRequests
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
                        .requestMatchers("/post/**").authenticated()
                        .anyRequest().permitAll())
                // 인증방식 설정
                .sessionManagement(session-> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 아래 코드에서 @Bean으로 등록
        http.addFilterBefore(new JwtAuthenticationFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost","http://localhost:3000"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.addAllowedHeader("*");
//        source.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    // JDBC를 이용한 사용자 목록을 이용할 때
    // @Bean
    public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
        // sql query를 전달하는 방법
        /*-> 결과 집합
        ┌────────────┬───────────┬───────────┐
        │  username  │  password │  enabled  │
         */
        String userSql = "select username, pwd password, 1 enabled from member where username=?";
        /*-> 결과 집합
        ┌────────────┬──────────────┐
        │  username  │  authority   │
        │   newlec   │  ROLE_ADMIN  │
        │   newlec   │  ROLE_MEMBER │
         */
        String rolesSql = "select username, 'ROLE_ADMIN' authority from member where username=?";

        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery(userSql);
        manager.setAuthoritiesByUsernameQuery(rolesSql);

        return manager;
    }


    // 메모리 상의 고정된 사용자 목록을 이용할 때
    // @Bean
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

    // UserDetails -> UserDetailsService
    /*
        1. 메모리 유저
        2. JdBC 유저
        3. X.500 유저
     */
}