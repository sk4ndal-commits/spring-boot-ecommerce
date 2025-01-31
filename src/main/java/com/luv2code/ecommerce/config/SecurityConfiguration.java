package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/orders/**").authenticated()
                        .anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults());

        httpSecurity.cors(cors ->
                cors.configurationSource(request ->
                        new org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues()));

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
}