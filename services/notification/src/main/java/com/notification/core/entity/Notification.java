package com.notification.core.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    @Indexed(unique=true)
    private String id;
    private Integer customerId;
    private String from;
    private String to;
    private String subject;

    private String text;
    private LocalDateTime createdAt;
}
