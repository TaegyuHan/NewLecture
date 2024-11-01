package kr.co.rland.boot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 인터럽트 URL
        http.authorizeHttpRequests(authorizeRequests -> // 요청에 대한 권한 설정
            authorizeRequests
                    .requestMatchers("/admin/**").authenticated()// /admin/** 경로는 인증 필요
                    .anyRequest().permitAll() // 나머지는 인증 필요 없음
        )
        // 인증 방식 설정
        .formLogin(Customizer.withDefaults());
        return http.build();
    }
}