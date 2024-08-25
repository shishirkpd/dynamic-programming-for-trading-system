package com.skp.model;

import java.util.List;

public class OrderBook {

    private List<Order> buy;

    private List<Order> sell;

    public OrderBook(List<Order> buy, List<Order> sell) {
        this.buy = buy;
        this.sell = sell;
    }

    public List<Order> getSell() {
        return sell;
    }

    public void setSell(List<Order> sell) {
        this.sell = sell;
    }

    public List<Order> getBuy() {
        return buy;
    }

    public void setBuy(List<Order> buy) {
        this.buy = buy;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
