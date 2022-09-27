package com.misiontic.reto3.controller;

import com.misiontic.reto3.entities.Client;
import com.misiontic.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId){
        return clientService.getClient(clientId);
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client b){
        return clientService.save(b);
    }

    @PutMapping("/update")
    public Client update(@RequestBody Client b){
        return clientService.update(b);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int clientId){
        return clientService.deleteClient(clientId);
    }

}
