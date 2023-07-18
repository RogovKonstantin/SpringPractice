package org.example.controllers.device;

import org.example.dto.DeviceDto;
import org.example.models.Device;
import org.example.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    Iterable<DeviceDto> all() {
        return deviceService.getAll();
    }

    @GetMapping("/devices/{id}")
    DeviceDto one(@PathVariable Integer id) throws Throwable {

        return (DeviceDto) deviceService.findDeviceById(id).orElseThrow(() -> new DeviceNotFoundException());
    }

    @GetMapping("/devicesbyserial/{serialNumber}")
    List<DeviceDto> devices(@PathVariable String serialNumber) throws Throwable {
        if (deviceService.findDevicesBySerialNumber(serialNumber).size() > 0) {
            return (List<DeviceDto>) deviceService.findDevicesBySerialNumber(serialNumber);
        } else {
            throw new DeviceNotFoundException();
        }
    }

    @GetMapping("/devicesorderscount/{serialNumber}")
    Integer devicescount(@PathVariable String serialNumber) throws Throwable {
        if (deviceService.countDeviceOrdersBySerialNumber(serialNumber) > 0) {
            return (Integer) deviceService.countDeviceOrdersBySerialNumber(serialNumber);
        } else if (deviceService.findDevicesBySerialNumber(serialNumber).size() == 0) {
            throw new DeviceNotFoundException();
        } else {
            throw new DeviceNotBoughtException();
        }}


        @PostMapping("/devices")
        public DeviceDto newDevice (@RequestBody DeviceDto deviceDto){
            return deviceService.add(deviceDto);
        }


        @DeleteMapping("/devices/{id}")
        void deleteDevice (@PathVariable Integer id){
            deviceService.deleteDevice(id);
        }

    }