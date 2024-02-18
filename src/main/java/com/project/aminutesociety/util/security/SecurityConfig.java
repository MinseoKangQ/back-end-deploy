package com.project.aminutesociety.util.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(AbstractHttpConfigurer::disable) // .cors(cors -> cors.disable())
                .csrf(AbstractHttpConfigurer::disable) // .csrf(csrf -> csrf.disable())
                .formLogin(AbstractHttpConfigurer::disable) // .formLogin(formLogin -> formLogin.disable())
                .authorizeRequests(authorize -> authorize
                        .anyRequest().permitAll())
                .build();
    }

}
