package org.example.services.impl;

import org.example.dto.ClientDto;
import org.example.models.Client;
import org.example.repo.ClientRepository;
import org.example.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService<Integer> {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public ClientDto add(ClientDto client) {
        Client c = modelMapper.map(client, Client.class);
        return modelMapper.map(clientRepository.save(c), ClientDto.class);
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll().stream().map((c) -> modelMapper.map(c, ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<ClientDto> findClientById(Integer id) {
        return Optional.ofNullable(modelMapper.map(clientRepository.findById(id), ClientDto.class));
    }

    @Override
    public void updateClientPhoneNumber(Integer id, String newPhoneNumber) {
        Client client = clientRepository.findClientById(id);
        client.setPhoneNumber(newPhoneNumber);
        clientRepository.save(client);
    }

    @Override
    public void updateClientPhoneNumber(ClientDto clientDto, String newPhoneNumber) {
        clientDto.setPhoneNumber(newPhoneNumber);
        clientRepository.save(clientRepository.findClientById(clientDto.getId()));
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteClient(ClientDto clientDto) {
        clientRepository.deleteById(clientDto.getId());
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        client.setId(clientDto.getId());
        return modelMapper.map(clientRepository.save(client), ClientDto.class);
    }


}

