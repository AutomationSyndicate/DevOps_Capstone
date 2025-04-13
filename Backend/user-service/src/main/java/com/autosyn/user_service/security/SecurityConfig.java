package com.autosyn.user_service.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    private final HttpSecurity httpSecurity;
//
//    public SecurityConfig(HttpSecurity httpSecurity) {
//        this.httpSecurity = httpSecurity;
//    }

    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/req/signup").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
