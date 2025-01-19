package com.rabbitmq.messageservice.controller;

import com.rabbitmq.messageservice.dto.MessageDto;
import com.rabbitmq.messageservice.publisher.RabbitMQJsonProducer;
import com.rabbitmq.messageservice.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer rabbitMQProducer;

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer, RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    /**
     * API for publish message for RabbitMQ queue
     * @param message
     * @return ResponseEntity
     */
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ.");
    }

    /**
     * API for publish message for RabbitMQ json queue
     * @param message
     * @return ResponseEntity
     */
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody MessageDto message){
        rabbitMQJsonProducer.sendJsonMessage(message);
        return ResponseEntity.ok("Json message sent to RabbitMQ.");
    }


}
