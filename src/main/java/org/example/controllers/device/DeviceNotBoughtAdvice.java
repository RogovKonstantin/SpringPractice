package org.example.controllers.device;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DeviceNotBoughtAdvice {
    @ResponseBody
    @ExceptionHandler(DeviceNotBoughtException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String deviceFoundHandler(DeviceNotBoughtException ex) {
        return ex.getMessage();}
}
