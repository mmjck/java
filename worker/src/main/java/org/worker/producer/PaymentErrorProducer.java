package org.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentErrorProducer {
    private final AmqpTemplate template;

    public PaymentErrorProducer(AmqpTemplate template) {
        this.template = template;
    }

    public void response(String msg){
        template.convertAndSend(
                "payment-response-error-exchange",
                "payment-response-error-rout-key",
                msg
        );
    }
}
