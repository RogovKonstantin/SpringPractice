package org.example.models;

import jakarta.persistence.*;
import org.example.dto.ManagerDto;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseModel {
    @Basic
    @Column(insertable = false, updatable = false)
    private Integer clientId;
    @Basic
    @Column(insertable = false, updatable = false)
    private Integer managerId;
    @ManyToOne
    @JoinColumn(name = "managerId", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.LOCK)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.LOCK)
    private Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<OrderList> orderLists;

    public Order(Integer id) {
        super(id);
        orderLists = new HashSet<OrderList>();

    }

    protected Order() {

    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrderList> getOrderLists() {
        return orderLists;
    }

    public void setOrderLists(Set<OrderList> orderLists) {
        this.orderLists = orderLists;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}

