package com.notification.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.core.entity.Notification;
import com.notification.dataprovider.NotificationDataProvider;
import com.notification.entrypoint.dto.EmailDto;
// import com.notification.entrypoint.dto.NotificationDto;


@Service
public class SendNotificationUseCase {
    
    @Autowired
    private NotificationDataProvider dataProvider;

    public void execute(EmailDto dto) {
        try {
            Notification notification = Notification.builder()
                    .customerId(1)
                    // .subject(dto.getSubject())
                    // .to(dto.getTo())
                    // .text(dto.getText())
                    // .from(dto.getFrom())
                    .build();

            this.dataProvider.sendEmail(notification);
        } catch (Exception e) {

        }
    }
}
