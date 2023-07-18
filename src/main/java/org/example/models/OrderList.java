package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@IdClass(OrderListId.class)
@Table(name = "orders_list")
public class OrderList {
    @Basic
    @Column(insertable=false, updatable=false)
    private Integer deviceId;
    @Basic
    @Column(insertable=false, updatable=false)
    private Integer orderId;
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "deviceId", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.LOCK)
    private Device device;

    public Order getOrder() {
        return order;
    }

    public Device getDevice() {
        return device;
    }

    public OrderList(Order order, Device device) {
        this.order = order;
        this.device = device;
    }

    public OrderList() {
    }
}
