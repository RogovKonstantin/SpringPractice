package org.example.models;

import java.io.Serializable;
import java.util.Objects;

public class OrderListId implements Serializable {
    private Device device;

    private Order order;

    public OrderListId(Device device, Order order) {
        this.device = device;
        this.order = order;
    }

    public OrderListId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderListId that)) return false;
        return Objects.equals(device, that.device) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {return Objects.hash(device, order);}
}
