package org.ms.consumer;

import org.ms.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

import org.ms.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;


public class PaymentResponseSuccessConsumer {
    private  final PaymentFacade facade;

    public PaymentResponseSuccessConsumer(PaymentFacade facade) {
        this.facade = facade;
    }

    @RabbitListener(queues = {"payment-response-success-queue"})
    public void receive(@Payload Message msg){
        String payload = String.valueOf(msg.getPayload());facade.successPayment(payload);

    }
}
