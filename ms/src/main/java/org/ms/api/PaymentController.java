package org.ms.api;

import org.ms.api.dto.PaymentDto;
import org.ms.facade.PaymentFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
    private final PaymentFacade paymentFacade;

    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PaymentDto dto){
        var response = this.paymentFacade.process(dto);
        return ResponseEntity.ok(response);

    }
}
