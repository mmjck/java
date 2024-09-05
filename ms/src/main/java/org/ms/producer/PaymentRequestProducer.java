package org.ms.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ms.api.dto.PaymentDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestProducer {
    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();
    public PaymentRequestProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void integrate(PaymentDto dto) throws JsonProcessingException {
        amqpTemplate.convertAndSend("payment-request-exchange",
                "payment-request-rout-key",
                objectMapper.writeValueAsString(dto));
    }

}
