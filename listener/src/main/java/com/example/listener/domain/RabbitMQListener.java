package com.example.listener.domain;

import com.example.crud.dto.Test;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RabbitMQListener {
    @RabbitListener(queues = "test_queue")
    public void listener(Test message){
        log.info("Message from queue: {}",message);
    }
}
