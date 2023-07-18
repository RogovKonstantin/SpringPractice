package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client extends BaseModel {
    @Basic
    private String login;
    @Basic
    private String phoneNumber;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Order> clientOrders;

    public Client(Integer id, String login, String phoneNumber, Set<Order> clientOrders) {
        super(id);
        this.login = login;
        this.phoneNumber = phoneNumber;
        this.clientOrders = clientOrders;
    }

    protected Client() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Order> getClientOrders() {
        return clientOrders;
    }

    public void setClientOrders(Set<Order> clientOrders) {
        this.clientOrders = clientOrders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}