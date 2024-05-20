package com.mmjck.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmjck.emailservice.adapters.EmailSenderGateway;
import com.mmjck.emailservice.core.cases.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase{

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway service){
        this.emailSenderGateway = service;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
    
}
