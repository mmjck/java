package org.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentSuccessProducer {
    private final AmqpTemplate template;

    public PaymentSuccessProducer(AmqpTemplate template) {
        this.template = template;
    }

    public void response(String msg){
        template.convertAndSend(
                "payment-response-success-exchange",
                "payment-response-success-rout-key",
                msg
        );
    }
}
