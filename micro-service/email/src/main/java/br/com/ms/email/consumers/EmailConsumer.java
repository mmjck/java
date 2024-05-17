package br.com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    
    
    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void receive(@Payload String str){
        System.out.println(str);
    }
}
