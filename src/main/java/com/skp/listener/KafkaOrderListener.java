package com.skp.listener;// KafkaOrderListener.java
import com.skp.service.OrderMatchingService;
import com.skp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderListener {

    @Autowired
    private OrderMatchingService orderMatchingService;

    @KafkaListener(topics = "orders", groupId = "trading")
    public void listen(Order order) {
        orderMatchingService.processOrder(order);
    }
}
