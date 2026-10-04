package com.springboot.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${app.kafka.topic.name}")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
