package org.example.controllers.device;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class DeviceNotFoundException extends RuntimeException{
    public DeviceNotFoundException() {
        super("Device not found");
    }
}

