package com.btg.orders_ms.adapters.configuration;

import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class BeanConfiguration {
    public static final String ORDER_CREATED_QUEUE = "btg-pactual-order-created";


    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    Declarable orderCreatedQueu(){
        return new Queue(ORDER_CREATED_QUEUE);
    }
}



