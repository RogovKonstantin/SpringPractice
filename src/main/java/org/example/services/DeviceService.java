package org.example.services;

import org.example.dto.ClientDto;
import org.example.dto.DeviceDto;
import org.example.models.OrderList;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DeviceService<ID> {
    DeviceDto add(DeviceDto device);

    List<DeviceDto> getAll();

    Optional<DeviceDto> findDeviceById(ID id);

    List<DeviceDto> findDevicesBySerialNumber(String serialNumber);

    Integer countDeviceOrdersBySerialNumber(String serialNumber);

    void updateDevicePrice(Integer id, BigDecimal newPrice);
    void updateDevicePrice(DeviceDto deviceDto, BigDecimal newPrice);
    void deleteDevice(ID id);
    void deleteDevice(DeviceDto device);
    DeviceDto updateDevice(DeviceDto deviceDto);


}
