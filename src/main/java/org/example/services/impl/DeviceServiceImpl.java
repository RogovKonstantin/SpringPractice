package org.example.services.impl;
import org.example.dto.ClientDto;
import org.example.dto.DeviceDto;
import org.example.models.Client;
import org.example.models.Device;
import org.example.repo.DeviceRepository;
import org.example.services.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService<Integer> {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeviceDto add(DeviceDto device) {
        Device d = modelMapper.map(device, Device.class);
        return modelMapper.map(deviceRepository.save(d), DeviceDto.class);
    }
    @Override
    public List<DeviceDto> getAll() {
        return deviceRepository.findAll().stream().map((d) -> modelMapper.map(d, DeviceDto.class)).collect(Collectors.toList());
    }
    @Override
    public Optional<DeviceDto> findDeviceById(Integer id) {
        return Optional.ofNullable(modelMapper.map(deviceRepository.findById(id), DeviceDto.class));
    }
    @Override
    public List<DeviceDto> findDevicesBySerialNumber(String serialNumber) {
        return deviceRepository.findAllBySerialNumber(serialNumber).stream().map((d) -> modelMapper.map(d, DeviceDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public Integer countDeviceOrdersBySerialNumber(String serialNumber) {
        return (deviceRepository.findOrderWithDevice(serialNumber).stream().map((d) -> modelMapper.map(d, DeviceDto.class))
                .collect(Collectors.toList())).size();
    }
    @Override
    public void updateDevicePrice(Integer id, BigDecimal newPrice) {
        Device device = deviceRepository.findDeviceById(id);
        device.setPrice(newPrice);
        deviceRepository.save(device);
    }
    @Override
    public void updateDevicePrice(DeviceDto deviceDto, BigDecimal newPrice) {
        deviceDto.setPrice(newPrice);
        deviceRepository.save(deviceRepository.findDeviceById(deviceDto.getId()));
    }

    @Override
    public void deleteDevice(Integer id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void deleteDevice(DeviceDto deviceDto) {
        deviceRepository.deleteById(deviceDto.getId());
    }

    @Override
    public DeviceDto updateDevice(DeviceDto deviceDto) {
        Device device = modelMapper.map(deviceDto, Device.class);
        device.setId(device.getId());
        return modelMapper.map(deviceRepository.save(device), DeviceDto.class);
    }

}
