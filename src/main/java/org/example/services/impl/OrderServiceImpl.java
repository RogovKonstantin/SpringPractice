package org.example.services.impl;

import org.example.dto.DeviceDto;
import org.example.dto.OrderDto;
import org.example.dto.OrderListDto;
import org.example.models.Client;
import org.example.models.Manager;
import org.example.models.Order;
import org.example.repo.ClientRepository;
import org.example.repo.DeviceRepository;
import org.example.repo.ManagerRepository;
import org.example.repo.OrderRepository;
import org.example.services.OrderListService;
import org.example.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService<Integer> {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private OrderListService orderListService;

    @Override
    public OrderDto add(OrderDto order) {
        Order o = modelMapper.map(order, Order.class);
        if (order.getClientId() != 0) {
            Client c = clientRepository.findById(order.getClientId()).get();
            o.setClient(c);
        }
        if (order.getManagerId() != 0) {
            Manager m = managerRepository.findById(order.getManagerId()).get();
            o.setManager(m);
        }
        return modelMapper.map(orderRepository.save(o), OrderDto.class);
    }


    @Override
    public List<OrderDto> getAll() {
        return orderRepository.findAll().stream().map((o) -> modelMapper.map(o, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDto> findOrderById(Integer id) {
        return Optional.ofNullable(modelMapper.map(orderRepository.findById(id), OrderDto.class));
    }


    @Override
    public List<DeviceDto> findAllDevicesInOrderWithId(Integer id) {
        return orderRepository.findAllDevicesByOrder(id).stream().map((d) -> modelMapper.map(d, DeviceDto.class)).collect(Collectors.toList());
    }


    @Override
    public void updateOrderManager(Integer id, Integer newManagerId) {
        Order order = orderRepository.findOrderById(id);
        order.setManager(managerRepository.findManagerById(newManagerId));
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {

        orderRepository.deleteById(id);

    }

    @Override
    public void deleteOrder(OrderDto orderDto) {
        orderRepository.deleteById(orderDto.getId());
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order.setId(orderDto.getId());
        return modelMapper.map(orderRepository.save(order), OrderDto.class);
    }




}