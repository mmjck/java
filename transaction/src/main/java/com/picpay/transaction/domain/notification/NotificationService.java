package com.picpay.transaction.domain.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.picpay.transaction.domain.transaction.Transaction;

@Service
public class NotificationService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);

    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }


    public void notifier(Transaction transaction) {
        LOGGER.info("notifying transaction {}...", transaction);
        notificationProducer.sendNotificatino(transaction);
    }


}


