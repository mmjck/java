package org.ms.consumer;

import org.ms.facade.PaymentFacade;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

public class PaymentResponseErrorConsumer {
    private  final PaymentFacade facade;

    public PaymentResponseErrorConsumer(PaymentFacade facade) {
        this.facade = facade;
    }

    @RabbitListener(queues = {"payment-response-error-queue"})
    public void receive(@Payload Message msg){
        String payload = String.valueOf(msg.getPayload());facade.successPayment(payload);
        facade.errorPayment(payload);
    }
}
