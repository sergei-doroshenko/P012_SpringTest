package org.sergei.domain;

/**
 * Created by Sergei_Doroshenko on 10/4/2016.
 */
public class Order {
    private Long orderId;

    private String orderName;

    public Order() {
    }

    public Order(Long orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
