package com.rabbitmq.messageservice.consumer;

import com.rabbitmq.messageservice.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    /**
     * Consume message from RabbitMQ queue
     * @param message
     */
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s", message));

    }

    /**
     * Consume message from RabbitMQ json queue
     * @param message
     */
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(MessageDto message){
        LOGGER.info(String.format("Received json message -> %s", message.toString()));

    }
}
