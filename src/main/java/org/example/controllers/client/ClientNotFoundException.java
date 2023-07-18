package org.example.controllers.client;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException() {
        super("Client not found");
    }
}

