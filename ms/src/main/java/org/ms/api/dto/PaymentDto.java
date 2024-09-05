package org.ms.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record PaymentDto(
        @JsonProperty("payment_id")
        String paymentId,
        BigDecimal value,
        String product
        ) {
}
