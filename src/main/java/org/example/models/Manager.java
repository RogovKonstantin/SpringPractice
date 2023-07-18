package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "managers")
public class Manager extends BaseModel{
    @Basic
    private String name;
    @Basic
    private String surname;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Order> managerOrders;

    public Manager(Integer id, String name, String surname) {
        super(id);
        this.name = name;
        this.surname = surname;
        managerOrders = new HashSet<Order>();
    }

    protected Manager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Order> getManagerOrders() {
        return managerOrders;
    }

    public void setManagerOrders(Set<Order> managerOrders) {
        this.managerOrders = managerOrders;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                '}';
    }
}
