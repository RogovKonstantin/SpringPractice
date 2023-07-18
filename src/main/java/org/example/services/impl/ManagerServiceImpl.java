package org.example.services.impl;
import org.example.dto.ClientDto;
import org.example.dto.ManagerDto;
import org.example.models.Client;
import org.example.models.Manager;
import org.example.repo.ClientRepository;
import org.example.repo.ManagerRepository;
import org.example.repo.OrderRepository;
import org.example.services.ManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService<Integer> {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ManagerDto add(ManagerDto manager) {
        Manager m = modelMapper.map(manager, Manager.class);
        return modelMapper.map(managerRepository.save(m), ManagerDto.class);

    }

    @Override
    public List<ManagerDto> getAll() {
        return managerRepository.findAll().stream().map((m) -> modelMapper.map(m, ManagerDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ManagerDto> findManagerById(Integer id) {
        return Optional.ofNullable(modelMapper.map(managerRepository.findById(id), ManagerDto.class));
    }

    @Override
    public List<ManagerDto> findManagerByName(String name) {
        return managerRepository.findByName(name).stream().map((m) -> modelMapper.map(m, ManagerDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> findClientsByManagerId(Integer id) {
        return managerRepository.findClientsByManager(id).stream().map((c) -> modelMapper.map(c,ClientDto.class)).collect(Collectors.toList());
    }
    @Override
    public void updateManagerSurname(Integer id, String surname) {
        Manager manager = managerRepository.findManagerById(id);
        manager.setSurname(surname);
        managerRepository.save(manager);
    }

    @Override
    public void updateManagerSurname(ManagerDto managerDto, String newManagerSurname) {
        managerDto.setSurname(newManagerSurname);
        managerRepository.save(managerRepository.findManagerById(managerDto.getId()));
    }

    @Override
    public void deleteManager(Integer id) {
        managerRepository.deleteById(id);
    }

    @Override
    public void deleteManager(ManagerDto managerDto) {
        managerRepository.deleteById(managerDto.getId());
    }

    @Override
    public ManagerDto updateManager(ManagerDto managerDto) {
        Manager manager = modelMapper.map(managerDto, Manager.class);
        manager.setId(managerDto.getId());
        return modelMapper.map(managerRepository.save(manager), ManagerDto.class);
    }




}
