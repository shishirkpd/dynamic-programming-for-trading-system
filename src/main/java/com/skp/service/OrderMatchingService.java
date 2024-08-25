package com.skp.service;// OrderMatchingService.java
import com.skp.model.Order;
import com.skp.model.OrderBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

@Service
public class OrderMatchingService {

    private final PriorityQueue<Order> buyOrders = new PriorityQueue<>(Comparator.comparingDouble(Order::getPrice).reversed());
    private final PriorityQueue<Order> sellOrders = new PriorityQueue<>(Comparator.comparingDouble(Order::getPrice));

    public void processOrder(Order order) {
        if (order.isBuyOrder()) {
            matchOrder(order, sellOrders, buyOrders);
        } else {
            matchOrder(order, buyOrders, sellOrders);
        }
    }

    private void matchOrder(Order order, PriorityQueue<Order> opposingOrders, PriorityQueue<Order> currentOrders) {
        while (!opposingOrders.isEmpty() && canMatch(order, opposingOrders.peek())) {
            Order opposingOrder = opposingOrders.poll();
            // Execute trade logic here, e.g., logging or sending trade details
            System.out.println("Trade Executed: Buy " + order + " with Sell " + opposingOrder);
        }
        currentOrders.add(order);
    }

    private boolean canMatch(Order buyOrder, Order sellOrder) {
        return buyOrder.getPrice() >= sellOrder.getPrice();
    }

    public OrderBook fetchOrderBook(int depth) {
        PriorityQueue<Order> buyCopy = new PriorityQueue<>(buyOrders);
        PriorityQueue<Order> sellCopy = new PriorityQueue<>(buyOrders);
        List<Order> buy = new ArrayList<>();
        List<Order> sell = new ArrayList<>();
        int i =0 ;
        while (i < depth) {
            buy.add(buyCopy.poll());
            sell.add(sellCopy.poll());
            i++;
        }
        return new OrderBook(buy, sell);
    }
}
