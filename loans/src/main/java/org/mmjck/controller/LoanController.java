package org.mmjck.controller;

import org.mmjck.controller.dto.CustomerLoanRequestDto;
import org.mmjck.controller.dto.CustomerLoanResponseDto;
import org.mmjck.service.LoansService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    private final LoansService service;

    public LoanController(LoansService service) {
        this.service = service;
    }


    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponseDto> customerLoans(@RequestBody CustomerLoanRequestDto dto) {

        var loans = this.service.checkAvailables(dto);

        return ResponseEntity.ok().body(new CustomerLoanResponseDto(dto.name(), loans));
    }
}
