package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device extends BaseModel{
    @Basic
    private String brand;
    @Basic
    private String model;
    @Basic
    private String colour;
    @Basic
    private BigDecimal price;
    @Basic
    private String serialNumber;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "device")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<OrderList> orderLists ;

    public Device(Integer id, String brand, String model, String colour, BigDecimal price, String serialNumber) {
        super(id);
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.price = price;
        this.serialNumber = serialNumber;
        orderLists = new HashSet<OrderList>();
    }

    protected Device() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Set<OrderList> getOrderLists() {
        return orderLists;
    }

    public void setOrderLists(Set<OrderList> orderLists) {
        this.orderLists = orderLists;
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", serialNumber='" + serialNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
