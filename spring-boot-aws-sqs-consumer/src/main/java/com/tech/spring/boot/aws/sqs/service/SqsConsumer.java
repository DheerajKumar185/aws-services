package com.tech.spring.boot.aws.sqs.service;

import com.tech.spring.boot.aws.sqs.dto.Customer;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SqsConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SqsConsumer.class);

    @SqsListener("${app.sqs.queue-name}")
    public void receiveMessage(String message) {
        logger.info("Received from SQS: {}", message);
    }

    @SqsListener("${app.sqs.queue-name}")
    public void consumeEvents(Customer customer) {
        logger.info("Received events from SQS: {}", customer);
    }
}