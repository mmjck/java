package com.customer.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {
    
    @Bean
    @LoadBalanced
    public RestTemplate execute(){
        return new RestTemplate();
    }
}
