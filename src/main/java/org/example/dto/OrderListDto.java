package org.example.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;


public class OrderListDto {
    private OrderDto order;
    private DeviceDto device;

    public OrderListDto() {
    }

    public OrderListDto(OrderDto order, DeviceDto device) {
        this.order = order;
        this.device = device;
    }

    public OrderDto getOrder() {return order;}

    public void setOrder(OrderDto order) {this.order = order;}

    public DeviceDto getDevice() {return device;}

    public void setDevice(DeviceDto device) {this.device = device;}

    @Override
    public String toString() {
        return "OrderListDto{" +
                "order=" + order +
                ", device=" + device +
                '}';
    }
}
