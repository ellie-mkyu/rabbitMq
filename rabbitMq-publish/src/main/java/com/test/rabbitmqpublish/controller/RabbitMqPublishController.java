package com.test.rabbitmqpublish.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.rabbitmqpublish.model.SendingModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequestMapping("/rabbit-mq")
@RestController
public class RabbitMqPublishController {

    private static final String EXCHANGE_NAME = "test.exchange";
    private static final String ROUTING_KEY = "test.rountingkey.#";

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public RabbitMqPublishController(
            RabbitTemplate rabbitTemplate,
            ObjectMapper objectMapper
    ){
            this.rabbitTemplate = rabbitTemplate;
            this.objectMapper = objectMapper;
    }

    @GetMapping(value = "test/queue/{message}")
    public String publishMessage(
            @PathVariable String message
    ) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(
                EXCHANGE_NAME,
                ROUTING_KEY,
                objectMapper.writeValueAsString(SendingModel.builder()
                        .username("test-user")
                        .message(message)
                        .build())
                );
        return "ok";
    }

    @GetMapping
    public String healthCheck() {
        return "ok";
    }
}
