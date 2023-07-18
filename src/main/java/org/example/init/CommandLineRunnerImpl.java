package org.example.init;

import org.aspectj.weaver.ast.Or;
import org.example.dto.*;
import org.example.repo.ClientRepository;
import org.example.repo.DeviceRepository;

import org.example.repo.ManagerRepository;
import org.example.repo.OrderRepository;
import org.example.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLOutput;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderListService orderListService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private DeviceRepository deviceRepository;


    @Override
    public void run(String... args) throws Exception {
        seedData();
    }


    private void seedData() throws IOException {
        // Девайс
        DeviceDto device1 = deviceService.add(new DeviceDto(0, "Samsung", "S8", "Black", new BigDecimal(19000), "1092"));
        DeviceDto device2 = deviceService.add(new DeviceDto(0, "Samsung", "S11", "Gray", new BigDecimal(19000), "1093"));
        DeviceDto device4 = deviceService.add(new DeviceDto(0, "Iphone", "11", "Gray", new BigDecimal(19000), "1"));
        DeviceDto device3 = deviceService.add(new DeviceDto(0, "Samsung", "S11", "Gray", new BigDecimal(19000), "1093"));
        //Клиент
        ClientDto client1 = clientService.add(new ClientDto(0, "Biill", "+7999"));
        ClientDto client2 = clientService.add(new ClientDto(0, "Tom", "+79996236"));
        ClientDto client3 = clientService.add(new ClientDto(0, "OHUENNIY_TIP", "+79996236"));
        //Менеджер
        ManagerDto manager1 = managerService.add(new ManagerDto(0, "Vasya", "Pupkin"));
        ManagerDto manager2 = managerService.add(new ManagerDto(0, "Kolya", "Pupkin"));
        ManagerDto manager3 = managerService.add(new ManagerDto(0, "Zaman", "Pupkin"));
        //Заказы
        OrderDto order1 = orderService.add(new OrderDto(0, 2, 1));
        orderListService.addDeviceToOrder(1,1);
        OrderDto order2 = orderService.add(new OrderDto(0, 2, 2));
        orderListService.addDeviceToOrder(1, 2);
        OrderDto order3 = orderService.add(new OrderDto(0, 1, 2));
        System.out.println(managerService.findClientsByManagerId(2));
        System.out.println(managerService.findClientsByManagerId(3));
        System.out.println(managerService.findClientsByManagerId(1));
        orderRepository.findAllDevicesByOrder(1).forEach(System.out::println);






    }
}