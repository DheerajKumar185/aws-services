# aws-services
# Spring Boot AWS SQS Producer & Consumer

This is a **Spring Boot 3.5.4** project demonstrating how to integrate with **Amazon Simple Queue Service (SQS)** using [Spring Cloud AWS].  
It supports publishing and consuming both **plain string messages** and **custom objects (Customer)**.

---

## Features

- 🚀 Publish messages to an AWS SQS queue using `SqsTemplate`
- 📥 Consume messages from SQS with `@SqsListener`
- 🧑‍💻 Supports **String** and **POJO (Customer)** payloads
- 🌱 Built with Spring Boot 3, Java 17, and Spring Cloud AWS 3.4.0

---

## Tech Stack

- **Java** 17  
- **Spring Boot** 3.5.4  
- **Spring Web**  
- **Spring Cloud AWS SQS** (`io.awspring.cloud:spring-cloud-aws-starter-sqs`)  
- **Lombok** (for model boilerplate)  
- **Maven**  

---

## Prerequisite
1. Create a queue using SQS
2. Create a User in IAM
3. Generate Access & Secret key
4. Add Permissions policies AmazonSQSFullAccess to provide access SQS to created user.

---

## REST Endpoints

1. curl -X GET http://localhost:8080/producer/publish/HelloSQS
2. curl --location 'localhost:8080/producer/publish' \
--header 'Content-Type: application/json' \
--data-raw '{ "name": "test", "email": "test@gmail.com", "contactNo": "1234567890" }'
