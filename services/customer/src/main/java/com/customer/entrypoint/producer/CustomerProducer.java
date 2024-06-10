package com.customer.entrypoint.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.customer.core.entity.Customer;
import com.customer.core.usecase.dto.EmailDto;

@Service
public class CustomerProducer {
      final RabbitTemplate rabbitTemplate;


    public CustomerProducer(RabbitTemplate template){
        this.rabbitTemplate = template;
    }


    @Value("${spring.rabbitmq.queue}")
    private String routingKey;


    public void publish(Customer customer){
        try {
            EmailDto data = EmailDto.builder()
            .to(customer.getEmail().toLowerCase())
            .build();

        rabbitTemplate.convertAndSend("", routingKey, data);
        System.out.println("Deu cero");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
