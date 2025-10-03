package com.luv2code.ecommerce.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class MyAppConfig : WebMvcConfigurer
{
    @Value($$"${spring.data.rest.base-path}")
    private val basePath: String? = null

    @Value($$"${allowed.origins}")
    private val theAllowedOrigins: Array<String?> = emptyArray()

    override fun addCorsMappings(cors: CorsRegistry)
    {
        cors.addMapping("$basePath/**").allowedOrigins(*theAllowedOrigins)
    }
}
