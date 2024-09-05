package org.worker.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.worker.producer.PaymentErrorProducer;
import org.worker.producer.PaymentSuccessProducer;

import java.util.Random;

@Component
public class PaymentRequestConsumer {

    private final PaymentSuccessProducer paymentSuccessProducer;
    private final PaymentErrorProducer paymentErrorProducer;

    public PaymentRequestConsumer(PaymentSuccessProducer paymentSuccessProducer, PaymentErrorProducer paymentErrorProducer) {
        this.paymentSuccessProducer = paymentSuccessProducer;
        this.paymentErrorProducer = paymentErrorProducer;
    }

    @RabbitListener(queues = {"payment-request-queue"})
    public void receive(@Payload Message message){
        if(new Random().nextBoolean()){
            paymentSuccessProducer.response("Success payment" + message);
        }else {
            paymentErrorProducer.response("Payment with error " + message);
        }
    }
}
