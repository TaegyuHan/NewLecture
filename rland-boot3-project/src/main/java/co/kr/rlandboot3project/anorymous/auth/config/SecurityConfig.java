 package co.kr.rlandboot3project.anorymous.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;

 @Configuration
 public class SecurityConfig {

     @Bean
     public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

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

             // hasRole: 권한이 있는지 확인
             // hasAnyRole: 여러 권한 중 하나라도 있는지 확인
             // authenticated: 인증이 되었는지 확인

             // 인증하기 위한 3요소
             // 1. 사용자 정보
             // 2. URL 경로
             // 3. 인증방식
             authorizeRequests
                     .requestMatchers("/admin/**").hasRole("ADMIN") // /admin/** 경로는 인증 필요
                     .requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER") // /user/** 경로는 인증 필요
                     .requestMatchers("/post/**").authenticated() // /post/** 경로는 인증 필요
                     .anyRequest().permitAll() // 나머지는 인증 필요 없음
         )
         .sessionManagement(session -> session
                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 사용하지 않음
         );

         // 인증 방식 설정 (SSR 인증방식)
//         .formLogin(formConfig ->
//             formConfig
//                 .loginPage("/user/signin") // GET 로그인 페이지 < CORS 가 발생한다.
//                 .loginProcessingUrl("/user/signin") // POST 로그인 처리 URL < CRSF 가 발생한다.
//                 .defaultSuccessUrl("/") // 로그인 성공 후 이동할 페이지

                 // 로그인 성공 후 원하는 권한이나 상황에 따라서 처리할 수 있는 핸들러
 //                .successHandler((request, response, authentication) -> {
 //                    response.sendRedirect("/");
 //                })


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

     // @Bean // JDBC를 이용한 사용자 목록을 이용할 때
     public UserDetailsService jdbcUserDetailsService(DataSource dataSource) {
         // sql query를 전달하는 방법

         /* -> 결과 집합 (이대로 맞춰서 사용해야 한다.)
             ┌──────────┬──────────┬──────────┐
             │ username │ password │ enabled  │
             └──────────┴──────────┴──────────┘
          */
         String userSql = "select username, pwd as password, 1 as enabled from member where username=?";

         /* -> 결과 집합
             ┌──────────┬────────────┐
             │ username │ authority  │
             │ newlec   │ ROLE_ADMIN │
             │ moomoo   │ ROLE_MEMBER│
          */
         String roleSql = "select username, 'ROLE_ADMIN' as authority from member where username=?";
         JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
         manager.setUsersByUsernameQuery(userSql);
         manager.setAuthoritiesByUsernameQuery(roleSql);
         return manager;
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

     // 메모리 상의 유저 정보
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
 }