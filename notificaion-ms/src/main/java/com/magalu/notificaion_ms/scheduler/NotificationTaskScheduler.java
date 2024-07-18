package com.magalu.notificaion_ms.scheduler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.magalu.notificaion_ms.service.NotificationService;

@Component
public class NotificationTaskScheduler {

    private final Logger logger = LoggerFactory.getLogger(NotificationTaskScheduler.class);

    private NotificationService service;

    
    public NotificationTaskScheduler(NotificationService service) {
        this.service = service;
    }


    @Scheduled(fixedDelay = 20, timeUnit = TimeUnit.SECONDS)
    public void checkTasks(){
        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime );

        service.checkAndSend(dateTime);

    }
}
