package com.mmjck.anota_ai.services.aws;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.mmjck.anota_ai.services.aws.dto.MessageDTO;

@Service
public class AwsSnsService {
    private AmazonSNS snsClient;
    private Topic catalogTopic;

    public AwsSnsService(AmazonSNS snsClient, @Qualifier("catalogEventsTopic") Topic catalogTopic) {
        this.snsClient = snsClient;
        this.catalogTopic = catalogTopic;
    }

    public void publish(MessageDTO message){
        this.snsClient.publish(catalogTopic.getTopicArn(), message.message());
    }
}
