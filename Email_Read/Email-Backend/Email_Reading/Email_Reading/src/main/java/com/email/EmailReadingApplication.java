package com.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmailReadingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailReadingApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurere() {
        WebMvcConfigurer web = new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                CorsRegistration registration = registry.addMapping("/**");
                registration.allowedOrigins("http://localhost:4200");
                registration.allowCredentials(true);
                registration.allowedHeaders("*");


            }
        };
        return web;
    }


}
