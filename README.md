# Kafka Trading System

## Overview

This project is a Spring Boot application designed for high-throughput trading systems using Apache Kafka. It includes Kafka producer and consumer setups with `ConcurrentKafkaListenerContainerFactory` to handle up to 10,000 messages per second. The application provides REST endpoints to produce trading orders to Kafka and consume them concurrently.

## Project Structure

- **ProducerService**: Produces trading orders to Kafka.
- **ConsumerService**: Consumes trading orders from Kafka.
- **KafkaConfig**: Configures Kafka producer and consumer settings, including `ConcurrentKafkaListenerContainerFactory`.

## Prerequisites

- JDK 17 or higher
- Apache Kafka (installed and running)
- Maven (for building the project)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/kafka-trading-system.git
```
### 2. Install Dependencies
   Ensure you have Maven installed. Run the following command to install the required dependencies:

```bash
mvn clean install
```
### 3. Configure Kafka
   Make sure your Kafka broker is running on localhost:9092 or update the bootstrapServers property in KafkaConfig.java to match your Kafka server configuration.

### 4. Run the Application
   Start the Spring Boot application using:

```bash
mvn spring-boot:run
```
### 5. Produce Messages
   You can produce trading orders by sending a POST request to the REST API:
```bash
http://localhost:8080/orders/send
```

Request Parameter:

`count` (integer): Number of orders to send.
Example:

```bash
curl -X POST "http://localhost:8080/orders/send?count=10000"
```

### 6. Fetch the order book

`count` (integer): Number of `orderbook` to fetch.
Example:
```bash
curl -X POST "http://localhost:8080/orders/book?count=5"
```