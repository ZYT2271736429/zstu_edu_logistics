package com.zstu.edu.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 解决跨域问题
 * @author ThinkPad
 */
@Configuration
public class AccessControlAllowOriginFilter extends WebMvcConfigurerAdapter {
    // SpringBoot2.4.0 [allowedOriginPatterns]代替[allowedOrigins]
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("PUT", "DELETE", "GET", "POST", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .allowCredentials(true).maxAge(3600);
    }
}
