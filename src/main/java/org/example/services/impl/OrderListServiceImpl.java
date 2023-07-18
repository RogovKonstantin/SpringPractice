package org.example.services.impl;
import org.example.dto.ClientDto;
import org.example.dto.OrderListDto;
import org.example.models.Device;
import org.example.models.Order;
import org.example.models.OrderList;
import org.example.repo.DeviceRepository;
import org.example.repo.OrderListRepository;
import org.example.repo.OrderRepository;
import org.example.services.OrderListService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderListServiceImpl implements OrderListService<Integer> {
    @Autowired
    OrderListRepository orderListRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private ModelMapper modelMapper;



    @Override
    public List<OrderListDto> addDeviceToOrder(Integer orderId, Integer deviceId) {
        Order order = orderRepository.findOrderById(orderId);
        Device device = deviceRepository.findDeviceById(deviceId);
        OrderList orderList1= new OrderList(order,device);
        orderListRepository.save(orderList1);
        List<OrderList> orders = new ArrayList<>();
        orders.add(orderList1);
        List<OrderListDto> allOrders = modelMapper.map(orders, List.class);
        return allOrders;
        }

    @Override
    public List<OrderListDto> getAll() {
        return orderListRepository.findAll().stream().map((o) -> modelMapper.map(o, OrderListDto.class)).collect(Collectors.toList());
    }


}



