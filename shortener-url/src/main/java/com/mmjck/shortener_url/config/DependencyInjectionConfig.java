package com.mmjck.shortener_url.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mmjck.shortener_url.domain.factory.impl.CommonUrlFactory;

@Configuration
public class DependencyInjectionConfig {
 
    @Bean 
    public CommonUrlFactory createUrlFactory(){
        return new CommonUrlFactory();
    }
}
