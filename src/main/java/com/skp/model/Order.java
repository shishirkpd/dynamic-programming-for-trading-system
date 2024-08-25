package com.skp.model;

// Order.java
public class Order {
    private String id;
    private double price;
    private long timestamp;
    private boolean isBuyOrder;

    // Constructors
    public Order() {}

    public Order(String id, double price, long timestamp, boolean isBuyOrder) {
        this.id = id;
        this.price = price;
        this.timestamp = timestamp;
        this.isBuyOrder = isBuyOrder;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public boolean isBuyOrder() { return isBuyOrder; }
    public void setBuyOrder(boolean buyOrder) { isBuyOrder = buyOrder; }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", timestamp=" + timestamp +
                ", isBuyOrder=" + isBuyOrder +
                '}';
    }
}
