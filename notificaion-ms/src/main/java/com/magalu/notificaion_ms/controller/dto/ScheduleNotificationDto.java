package com.magalu.notificaion_ms.controller.dto;

import java.time.LocalDateTime;

import com.magalu.notificaion_ms.entity.Channel;
import com.magalu.notificaion_ms.entity.Notification;
import com.magalu.notificaion_ms.entity.Status;

public record ScheduleNotificationDto(
    LocalDateTime dateTime,
    String destination,
    String message,
    Channel.Values channel
) {
    public Notification toNotification(){
        return new Notification(
            dateTime,
            destination,
            message,
            channel.toChannel(),
            Status.Values.PENDING.toStatus()
        );
    }
}
