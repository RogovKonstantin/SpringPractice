package org.example.services;

import org.example.dto.ClientDto;
import org.example.dto.DeviceDto;
import org.example.dto.ManagerDto;

import java.util.List;
import java.util.Optional;

public interface ManagerService<ID> {
    ManagerDto add(ManagerDto manager);

    List<ManagerDto> getAll();

    Optional<ManagerDto> findManagerById(ID id);

    List<ManagerDto> findManagerByName(String name);

    List<ClientDto> findClientsByManagerId(ID id);
    void updateManagerSurname(Integer id,String newManagerSurname);
    void updateManagerSurname(ManagerDto managerDto,String newManagerSurname);

    void deleteManager(ID id);
    void deleteManager(ManagerDto managerDto);
    ManagerDto updateManager(ManagerDto managerDto);
}
