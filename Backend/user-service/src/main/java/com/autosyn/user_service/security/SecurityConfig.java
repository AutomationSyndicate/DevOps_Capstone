//package com.autosyn.user_service.security;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import lombok.AllArgsConstructor;
//
//@Configuration
//@AllArgsConstructor
//@EnableWebSecurity
//public class SecurityConfig {
//
////    private final HttpSecurity httpSecurity;
////
////    public SecurityConfig(HttpSecurity httpSecurity) {
////        this.httpSecurity = httpSecurity;
////    }
//
////    @Bean
////    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http
////                .formLogin(form -> form
////                        .loginPage("/login")
////                        .permitAll()
////                )
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/req/signup").permitAll()
////                        .anyRequest().authenticated()
////                )
////                .build();
//
////        return http
////                .formLogin(httpForm ->{
////                    httpForm
////                            .loginPage("/req/login").permitAll();
////                })
////
////                .authorizeHttpRequests(registry ->{
////                    registry.requestMatchers("/req/signup").permitAll();
////                    registry.anyRequest().authenticated();
////                })
////                .build();
//
//    }
//}
