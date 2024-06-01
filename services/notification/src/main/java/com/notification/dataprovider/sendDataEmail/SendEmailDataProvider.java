package com.notification.dataprovider.sendDataEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notification.core.entity.Notification;

// @Service
public class SendEmailDataProvider {
    
    @Autowired
    private JavaMailSender sender;
    
   
    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public void send(Notification notification){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getTo());
        message.setSubject(notification.getSubject());
        message.setText(notification.getText());

        sender.send(message);

    }
}   
