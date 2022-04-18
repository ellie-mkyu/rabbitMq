package com.test.rabbitmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class RabbitMqService {

    @RabbitListener(queues = "test.queue")
    public void receiveMessage(
            final Message message
    ) {
        log.info("message received: {}", message.toString());
        log.info("message : {}", message.getBody().toString());
    }
}
