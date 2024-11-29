package com.example.Agendamento_Consultas.services;


import com.example.Agendamento_Consultas.entities.Client;
import com.example.Agendamento_Consultas.entities.Scheduling;
import com.example.Agendamento_Consultas.repositories.ClientRepository;
import com.example.Agendamento_Consultas.repositories.SchedulingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRespository;
    private final ClientRepository clientRepository;

    public SchedulingService(SchedulingRepository schedulingRepository, ClientRepository clientRepository){
        this.schedulingRespository = schedulingRepository;
        this.clientRepository = clientRepository;
    }

    public Scheduling createScheduling(Scheduling scheduling) {
        Optional<Scheduling> conflict = schedulingRespository
                .findByDateAndTime(scheduling.getDate(), scheduling.getTime());

        if(conflict.isPresent()){
            throw new RuntimeException("Já existe um agendamento para esse horário!");
        }

        return schedulingRespository.save(scheduling);
    }

    @GetMapping("/scheduling")
    public List<Scheduling> getAllSchedulings() {
        return schedulingRespository.findAll();
    }

    public Scheduling getSchedulingById(Long id) {
        return schedulingRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public List<Scheduling> getSchedulingsByClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return schedulingRespository.findByClient(client);
    }

    @PostMapping("/scheduling")
    public ResponseEntity<Scheduling> saveScheduling(@RequestBody Scheduling scheduling) {
        Client client = scheduling.getClient();
        if (client.getId() == null) {
            client = clientRepository.save(client);
        }
        scheduling.setClient(client);
        Scheduling savedScheduling = schedulingRespository.save(scheduling);
        return ResponseEntity.ok(savedScheduling); // Retorna o agendamento salvo
    }

}
