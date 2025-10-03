package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
open class SecurityConfiguration
{

    @Bean
    @Throws(Exception::class)
    open fun filterChain(httpSecurity: HttpSecurity?): SecurityFilterChain?
    {
        httpSecurity
            ?.authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/api/orders/**").authenticated()
                    .anyRequest().permitAll()
            }
            ?.httpBasic(Customizer.withDefaults())

        httpSecurity?.cors { cors ->
            cors.configurationSource {
                org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues()
            }
        }

        httpSecurity?.csrf { csrf ->
            csrf.disable()
        }

        return httpSecurity?.build();
    }
}