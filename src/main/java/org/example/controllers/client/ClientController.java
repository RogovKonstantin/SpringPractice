package org.example.controllers.client;

import org.example.dto.ClientDto;

import org.example.dto.DeviceDto;
import org.example.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    Iterable<ClientDto> all() {
        return clientService.getAll();
    }

    @PostMapping("/clients")
    public ClientDto newClient (@RequestBody ClientDto clientDto){
        return clientService.add(clientDto);
    }
    @GetMapping("/clients/{id}")
    ClientDto one(@PathVariable Integer id) throws Throwable {

        return (ClientDto) clientService.findClientById(id).orElseThrow(() -> new ClientNotFoundException());
    }
    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Integer id){clientService.deleteClient(id);}
    @PutMapping("/clients/{id}")
    public ClientDto clientDto(@PathVariable Integer id,@RequestBody ClientDto clientDto){
        clientDto.setId(id);
        return clientService.updateClient(clientDto);
    }


}
