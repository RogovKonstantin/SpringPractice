package org.example.controllers.order;

import org.example.dto.DeviceDto;
import org.example.dto.OrderDto;
import org.example.dto.OrderListDto;
import org.example.models.OrderList;
import org.example.services.DeviceService;
import org.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeviceService deviceService;
    @GetMapping("/orders")
    Iterable<OrderDto> all(){return orderService.getAll();
    }
    @PostMapping("/orders")
    public OrderDto newOrder (@RequestBody OrderDto orderDto){
        return orderService.add(orderDto);
    }

    @GetMapping("/orderlist/{id}")
    List<OrderDto> orderList(@PathVariable Integer id)throws Throwable {
        if(orderService.findAllDevicesInOrderWithId(id).size() > 0){
            return (List<OrderDto>) orderService.findAllDevicesInOrderWithId(1);
        }
        else if((orderService.findOrderById(id)).isEmpty()){
            throw new OrderNotFoundException();
        }
        else{throw new EmptyOrderException();}
    }

    @DeleteMapping("/order/{id}")
    void deleteOrder(@PathVariable Integer id){orderService.deleteOrder(id);}


}