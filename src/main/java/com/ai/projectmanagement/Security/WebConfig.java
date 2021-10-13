package com.ai.projectmanagement.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        BCryptPasswordEncoder bCrypEncoder = new BCryptPasswordEncoder();

        return bCrypEncoder;

    }








}
