package com.fraud;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "frauds")
public class FraudCheckHistory {
    @Id
    @Indexed(unique=true)
    private String id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
