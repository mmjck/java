package br.com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.ms.email.dtos.EmailRecordDto;
import br.com.ms.email.model.EmailModel;
import br.com.ms.email.services.EmailService;

@Component
public class EmailConsumer {
    private EmailService service;
    
    public EmailConsumer(EmailService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void receive(@Payload EmailRecordDto dto){
        var model = new EmailModel();

        BeanUtils.copyProperties(dto, model);
        service.sendEmail(model);
    }
}
