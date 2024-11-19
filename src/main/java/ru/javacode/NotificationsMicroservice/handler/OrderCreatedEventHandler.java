package ru.javacode.NotificationsMicroservice.handler;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.javacode.core.OrderCreatedEvent;

@Component
@KafkaListener(topics = "sent-orders-topic")
@AllArgsConstructor
public class OrderCreatedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaHandler
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        LOGGER.info("Received event: {}", orderCreatedEvent.getNameProduct());
        //TODO logic notification user
    }
}
