package com.notification.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class NotificationDto {
     private  String id;
    private  String to;
    private  String from;
    private  String subject;
    private  String text;
}

