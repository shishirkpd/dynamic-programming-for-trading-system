package com.skp.controller;// OrderController.java
import com.skp.model.OrderBook;
import com.skp.service.OrderBookService;
import com.skp.service.OrderProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducerService orderProducerService;

    @Autowired
    private OrderBookService orderBookService;

    @PostMapping("/send")
    public void sendOrders(@RequestParam int count) {
        orderProducerService.sendOrders(count);
    }

    @GetMapping("/book")
    public OrderBook getOrderBook(@RequestParam int count) {
        return orderBookService.fetchCurrentOrderBook(count);
    }
}
