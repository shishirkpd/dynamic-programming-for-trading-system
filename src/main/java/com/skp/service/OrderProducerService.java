package com.skp.service;// OrderProducerService.java
import com.skp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class OrderProducerService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private final String topic = "orders";
    private final ExecutorService executor = Executors.newFixedThreadPool(10); // Number of threads

    public void sendOrders(int count) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            final Order order = new Order("order-" + i, Math.random() * 10000, System.currentTimeMillis(), i % 3 == 0);
            executor.submit(() -> kafkaTemplate.send(topic, order));
        }

        shutdownExecutor();
        long end = System.currentTimeMillis();
        System.out.println("Sent " + count + " orders in " + (end - start) + " ms");
    }

    private void shutdownExecutor() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
