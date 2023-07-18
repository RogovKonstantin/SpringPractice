package org.example.controllers.manager;

import org.example.dto.ClientDto;
import org.example.dto.ManagerDto;
import org.example.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers")
    Iterable<ManagerDto> all() {
        return managerService.getAll();
    }

    @GetMapping("/managersbyname/{name}")
    List<ManagerDto> managers(@PathVariable String name) throws Throwable {
        if (managerService.findManagerByName(name).size() > 0) {
            return (List<ManagerDto>) managerService.findManagerByName(name);
        } else {
            throw new ManagerNotFoundException();
        }
    }

    @GetMapping("/managerclients/{id}")
    List<ClientDto> managers(@PathVariable Integer id) throws Throwable {
        if (managerService.findClientsByManagerId(id).size() > 0) {
            return (List<ClientDto>) managerService.findClientsByManagerId(id);
        } else if (managerService.findClientsByManagerId(id).size() == 0) {
            throw new ManagerClientsNotFoundException();

        } else {
            throw new ManagerNotFoundException();
        }
    }

    @PostMapping("/managers")
    public ManagerDto newManager(@RequestBody ManagerDto managerDto){
        return managerService.add(managerDto);
    }

    @GetMapping("/managers/{id}")
    ManagerDto one(@PathVariable Integer id) throws Throwable {

        return (ManagerDto) managerService.findManagerById(id).orElseThrow(() -> new ManagerNotFoundException());
    }

    @DeleteMapping("/managers/{id}")
    void deleteManager(@PathVariable Integer id) {
        managerService.deleteManager(id);
    }
}
