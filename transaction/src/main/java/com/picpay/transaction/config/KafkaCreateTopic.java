package com.picpay.transaction.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaCreateTopic {

    static public final String TOPIC_NAME = "transaction-notification";
    static public final String GROUPD_ID_NAME = "transactions-ms";

    @Bean
    NewTopic createTopic(){
        return TopicBuilder.name(TOPIC_NAME).build();
    }
}