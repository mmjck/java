package br.com.ms.user.producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.ms.user.dtos.EmailDto;
import br.com.ms.user.model.UserModel;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;


    public UserProducer(RabbitTemplate template){
        this.rabbitTemplate = template;
    }


    @Value("${broker.queue.email.name}")
    private String routingKey;


    public void publish(UserModel user){
        var emailDto = new EmailDto();
        emailDto.setTo(user.getEmail());
        emailDto.setId(user.getId());
        emailDto.setSubject("Cadastro realizado com sucesso");
        emailDto.setText(user.getName() + "\n Agradecemos o seu cadastro!!!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }
}
