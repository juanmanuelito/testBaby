package com.example.crud.domain;

import com.example.crud.dto.Test;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publish(Test test) {
        rabbitTemplate.convertAndSend("test_queue", test);
    }
}
