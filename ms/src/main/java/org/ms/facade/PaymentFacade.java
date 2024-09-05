package org.ms.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.ms.api.dto.PaymentDto;
import org.ms.producer.PaymentRequestProducer;
import org.springframework.stereotype.Service;

@Service
public class PaymentFacade {

    private final PaymentRequestProducer producer;

    public PaymentFacade(PaymentRequestProducer producer) {
        this.producer = producer;
    }

    public String process(PaymentDto dto) {
        try {
            producer.integrate(dto);
        } catch (JsonProcessingException e) {
            return  "Error to process payment";
        }
        return  "Payment in processing";
    }

    public void successPayment(String payload) {
        System.out.println("======== SUCCESS PAYMENT =======");
        System.out.println(payload);
    }

    public void errorPayment(String payload) {
        System.out.println("======== Error PAYMENT =======");
        System.out.println(payload);
    }
}
