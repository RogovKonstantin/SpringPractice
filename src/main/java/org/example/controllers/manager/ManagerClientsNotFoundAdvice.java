package org.example.controllers.manager;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManagerClientsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ManagerClientsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ManagerClientsNotFoundException(ManagerClientsNotFoundException exception) {
        return exception.getMessage();
    }
}
