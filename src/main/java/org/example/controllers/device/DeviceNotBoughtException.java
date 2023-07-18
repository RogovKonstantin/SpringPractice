package org.example.controllers.device;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class DeviceNotBoughtException extends RuntimeException{
    public DeviceNotBoughtException() {
        super("Device never been bought");
    }
}