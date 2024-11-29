package com.example.Agendamento_Consultas.controllers;


import com.example.Agendamento_Consultas.entities.Client;
import com.example.Agendamento_Consultas.repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> listClient(){
        return clientRepository.findAll();
    }

    @PostMapping
    public Client registerClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

}
