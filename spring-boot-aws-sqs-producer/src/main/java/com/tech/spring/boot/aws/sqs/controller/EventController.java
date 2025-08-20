package com.tech.spring.boot.aws.sqs.controller;

import com.tech.spring.boot.aws.sqs.dto.Customer;
import com.tech.spring.boot.aws.sqs.service.SqsProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class EventController {
    private final SqsProducer sqsProducer;

    public EventController(SqsProducer sqsProducer) {
        this.sqsProducer = sqsProducer;
    }

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable("message") String message) {
        try {
            sqsProducer.sendMessage(message);
            return ResponseEntity.ok("message publish Successfully...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish")
    public ResponseEntity<?> publishEvents(@RequestBody Customer customer) {
        try {
            sqsProducer.sendEvents(customer);
            return ResponseEntity.ok("events publish Successfully...");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
