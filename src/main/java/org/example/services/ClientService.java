package org.example.services;

import org.example.dto.ClientDto;
import org.example.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService<ID> {
    ClientDto add(ClientDto client);
    List<ClientDto> getAll();


    Optional<ClientDto> findClientById(ID id);


    void updateClientPhoneNumber(Integer id, String newPhoneNumber);
    void updateClientPhoneNumber(ClientDto clientDto, String newPhoneNumber);
    void deleteClient(ID id);
    void deleteClient(ClientDto clientDto);
    ClientDto updateClient(ClientDto clientDto);

}
