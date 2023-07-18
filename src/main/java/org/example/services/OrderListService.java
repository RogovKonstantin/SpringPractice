package org.example.services;

import org.example.dto.DeviceDto;
import org.example.dto.OrderDto;
import org.example.dto.OrderListDto;
import org.example.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderListService<ID> {

    List<OrderListDto> addDeviceToOrder(Integer orderId, Integer deviceId);
    List<OrderListDto> getAll();


}
