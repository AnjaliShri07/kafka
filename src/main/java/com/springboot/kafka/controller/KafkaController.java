package com.springboot.kafka.controller;

import com.springboot.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducerService producerService;
    private final String topicName;

    @Autowired
    public KafkaController(KafkaProducerService producerService,
                          @Value("${app.kafka.topic.name}") String topicName) {
        this.producerService = producerService;
        this.topicName = topicName;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
        producerService.sendMessage(topicName, message);
        return ResponseEntity.ok("Message published to Kafka topic: " + topicName);
    }
}
