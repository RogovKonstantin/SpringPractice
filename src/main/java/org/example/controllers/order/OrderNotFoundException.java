package org.example.controllers.order;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(){
        super("Order not found");
    }
}