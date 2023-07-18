package org.example.controllers.manager;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException(){
        super("Manager not found");
    }
}