package com.chucknorris.challenge.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Template {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
