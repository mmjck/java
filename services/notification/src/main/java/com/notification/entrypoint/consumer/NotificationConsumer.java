package com.notification.entrypoint.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.notification.core.usecase.SendNotificationUseCase;
import com.notification.entrypoint.dto.NotificationDto;

@Component
public class NotificationConsumer {
    @Autowired
    SendNotificationUseCase useCase;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receive(@Payload NotificationDto dto){
        try {
            useCase.execute(dto);
        } catch (Exception e) {
            e.printStackTrace();            
        }
    }    
}
