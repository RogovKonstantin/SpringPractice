package org.example.services;

import org.example.dto.DeviceDto;
import org.example.dto.OrderDto;
import org.example.dto.OrderListDto;

import java.util.List;
import java.util.Optional;

public interface OrderService<ID>{
    OrderDto add(OrderDto order);
    List<OrderDto> getAll();
    Optional<OrderDto> findOrderById(Integer id);
    void updateOrderManager(Integer id, Integer newManagerId);
    void deleteOrder(ID id);
    void deleteOrder(OrderDto orderDto);
    OrderDto updateOrder (OrderDto orderDto);
    List<DeviceDto> findAllDevicesInOrderWithId(ID id);
}
