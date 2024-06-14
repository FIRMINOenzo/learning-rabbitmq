# Learning RabbitMQ

This is a simple payment micro-service that uses RabbitMQ to confirm payment asynchronously.

## Technologies

- Java
- Spring Boot
- Docker
- RabbitMQ

## How it works

The `POST /payment` endpoint sends a payment order confirmation to a RabbitMQ queue when it receives a request.
This queue is consumed by a worker, that validates the payment and then returns error or success.
