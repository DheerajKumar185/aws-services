package com.tech.spring.boot.aws.sqs.service;

import com.tech.spring.boot.aws.sqs.dto.Customer;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class SqsProducer {
    private static final Logger logger = LoggerFactory.getLogger(SqsProducer.class);

    private final SqsTemplate sqsTemplate;
    private final String queueName;

    public SqsProducer(SqsTemplate sqsTemplate,
                       @Value("${app.sqs.queue-name}") String queueName) {
        this.sqsTemplate = sqsTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(String payload) {
        logger.info("payload: {}", payload);
        sqsTemplate.send(opts -> opts.queue(queueName).payload(payload));
        logger.info("payload sent successfully");
    }

    public void sendEvents(Customer payload) {
        logger.info("payload: {}", payload);
        sqsTemplate.send(opts -> opts.queue(queueName).payload(payload));
        logger.info("payload sent successfully");
    }
}