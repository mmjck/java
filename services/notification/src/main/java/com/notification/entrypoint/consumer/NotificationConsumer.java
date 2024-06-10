package com.notification.entrypoint.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.notification.core.usecase.SendNotificationUseCase;
import com.notification.entrypoint.dto.EmailDto;


@Component
public class NotificationConsumer {
    @Autowired
    private SendNotificationUseCase useCase;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receive(
        @Payload EmailDto dto
        ){
        try {
            
            System.out.println(" called");
            // System.out.println(dto.getTo());
            // this.useCase.execute(dto);
        } catch (Exception e) {
            // e.printStackTrace();            
        }
    }    
}
