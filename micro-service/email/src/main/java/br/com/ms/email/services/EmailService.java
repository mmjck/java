package br.com.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.ms.email.enums.StatusEmail;
import br.com.ms.email.model.EmailModel;
import br.com.ms.email.repositories.EmailRepository;

@Service
public class EmailService {
    final EmailRepository emailRepository;
    final JavaMailSender eMailSender;
    
    
    public EmailService(JavaMailSender eMailSender, EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
        this.eMailSender = eMailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public EmailModel sendEmail(EmailModel model){
        try {
            model.setSendDateEmail(LocalDateTime.now());
            model.setFrom(emailFrom);
            

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(model.getTo());
            message.setSubject(model.getSubject());
            message.setText(model.getText());

            eMailSender.send(message);

            model.setStatusEmail(StatusEmail.SENT);
        } catch (Exception e) {
            model.setStatusEmail(StatusEmail.ERROR);
        }
        
        
        return emailRepository.save(model);
    }


    
}
