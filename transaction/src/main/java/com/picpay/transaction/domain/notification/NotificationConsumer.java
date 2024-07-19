package com.picpay.transaction.domain.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.picpay.transaction.config.KafkaCreateTopic;
import com.picpay.transaction.domain.transaction.Transaction;


@Service
public class NotificationConsumer {
    private RestClient restClient;
  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
        .baseUrl("SERVICE_AUTHORIZER")
        .build();
    }


    @KafkaListener(topics = KafkaCreateTopic.TOPIC_NAME, groupId = KafkaCreateTopic.GROUPD_ID_NAME)
    public void receiveNotification(Transaction transaction){
        var response = restClient.get()
            .retrieve()
            .toEntity(Notification.class);

            if(response.getStatusCode().isError() || !response.getBody().message()){
                throw new NotificatinoException("Error sending notification");
            }
            LOGGER.info("notification has been sent {}...", transaction.toString());

    }
    
}
