package com.magalu.notificaion_ms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.magalu.notificaion_ms.controller.dto.ScheduleNotificationDto;
import com.magalu.notificaion_ms.entity.Notification;
import com.magalu.notificaion_ms.entity.Status;
import com.magalu.notificaion_ms.repository.NotificationRepository;

@Service
public class NotificationService {
    private NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }


    public void create(ScheduleNotificationDto dto){
        repository.save(dto.toNotification());
    }

    public List<Notification> findAll(){
        return repository.findAll();
    }

    public Optional<Notification> findById(Long notificationId){
        return this.repository.findById(notificationId);
    }


    public void cancelNotification(Long notificationId){
        var notification = this.findById(notificationId);

        if(notification.isPresent()){
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            this.repository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime){
        var notifications = repository.findByStatusInAndDateTimeBefore(
            List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()
            ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification(){
        return n -> {
            n.setStatus(Status.Values.SUCCESS.toStatus());
            this.repository.save(n);
        };
        
    }
}
