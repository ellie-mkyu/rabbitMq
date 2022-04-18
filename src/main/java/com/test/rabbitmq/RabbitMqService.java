package com.test.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Log4j2
@EnableRabbit
@Component
public class RabbitMqService {

    private final ObjectMapper objectMapper;

    public RabbitMqService(
            ObjectMapper objectMapper
    ) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "test.queue")
    public void receiveMessage(
            final String message
    ) throws JsonProcessingException {
        log.info("message received: {}", message);
        ReceivedMessageModel model = objectMapper.readValue(message, ReceivedMessageModel.class);
        log.info("model's username: {}", model.getUsername());
        log.info("model's message: {}", model.getMessage());
    }
}
