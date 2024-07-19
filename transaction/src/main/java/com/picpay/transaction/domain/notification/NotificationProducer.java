package com.picpay.transaction.domain.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.picpay.transaction.config.KafkaCreateTopic;
import com.picpay.transaction.domain.transaction.Transaction;

@Service
public class NotificationProducer {
    private final KafkaTemplate<String, Transaction> kafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    

    public void sendNotificatino(Transaction transaction){
        kafkaTemplate.send(KafkaCreateTopic.GROUPD_ID_NAME, transaction);
    }
    

}
