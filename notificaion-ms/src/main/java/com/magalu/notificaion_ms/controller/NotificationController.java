package com.magalu.notificaion_ms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magalu.notificaion_ms.controller.dto.ScheduleNotificationDto;
import com.magalu.notificaion_ms.entity.Notification;
import com.magalu.notificaion_ms.service.NotificationService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService service;

    
    public NotificationController(NotificationService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Void> scheduleNotifications(@RequestBody ScheduleNotificationDto dto) {
        this.service.create(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAll() {
        List<Notification> data = this.service.findAll();
        return ResponseEntity.ok(data);
    }
    

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> findById(@PathVariable("notificationId") Long notificationId) {
        var notification = this.service.findById(notificationId);

        if(!notification.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());

    }


    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId) {
        this.service.cancelNotification(notificationId);
        return ResponseEntity.accepted().build();

    }
    
    
}
