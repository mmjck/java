package com.btg.orders_ms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.btg.orders_ms.adapters.configuration.BeanConfiguration;
import com.btg.orders_ms.application.port.incoming.CreateOrderUseCase;
import com.btg.orders_ms.dto.OrderCreatedEvent;

@Component
public class OrderCreatedListener {

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedEvent.class);

    private final CreateOrderUseCase createOrderUseCase;

    public OrderCreatedListener(
            CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @RabbitListener(queues = BeanConfiguration.ORDER_CREATED_QUEUE)
    public void listen(Message<OrderCreatedEvent> message) {

        try {
            logger.info("Message consumed:  {}", message.getPayload());
            createOrderUseCase.save(message.getPayload());
        } catch (Exception e) {
            logger.error("e", e);
        }

    }
}
