package com.skp.service;

import com.skp.model.OrderBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookService {

    @Autowired
    private OrderMatchingService orderMatchingService;


    public OrderBook fetchCurrentOrderBook(int depth) {
        return orderMatchingService.fetchOrderBook(depth);
    }
}
