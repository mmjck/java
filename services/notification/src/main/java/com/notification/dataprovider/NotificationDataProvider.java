package com.notification.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.core.entity.Notification;
import com.notification.core.gateway.NotificationGateway;
import com.notification.dataprovider.repository.NotificationRespository;
import com.notification.dataprovider.sendDataEmail.SendEmailDataProvider;

@Service
public class NotificationDataProvider implements NotificationGateway {

    @Autowired(required = true)
    NotificationRespository respository;

    // @Autowired(required = true)
    // SendEmailDataProvider sendEmailDataProvider;

    @Override
    public void create(Notification data) {
        respository.save(data);
    }

    @Override
    public void sendEmail(Notification data) {
        try {
            

            System.out.println(data.toString());
            // sendEmailDataProvider.send(data);
            // respository.save(data);

        } catch (Exception e) {
            throw new RuntimeException("error");
        }

    }

}
