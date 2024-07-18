package com.magalu.notificaion_ms.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magalu.notificaion_ms.entity.Notification;
import com.magalu.notificaion_ms.entity.Status;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);
}
