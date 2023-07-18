package org.example.controllers.order;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class EmptyOrderException extends RuntimeException{
    public EmptyOrderException(){
        super("This order is empty");
    }
}
