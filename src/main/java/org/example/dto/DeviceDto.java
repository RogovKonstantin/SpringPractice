package org.example.dto;

import java.math.BigDecimal;

public class DeviceDto {
    private Integer id;

    private String brand;

    private String model;

    private String colour;

    private BigDecimal price;

    private String serialNumber;

    public DeviceDto(Integer id, String brand, String model, String colour, BigDecimal price, String serialNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    public DeviceDto() {}

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
