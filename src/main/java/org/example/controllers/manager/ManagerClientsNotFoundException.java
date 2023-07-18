package org.example.controllers.manager;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ManagerClientsNotFoundException extends RuntimeException {
    public ManagerClientsNotFoundException() {
        super("This manager does not have clients");
    }
}

