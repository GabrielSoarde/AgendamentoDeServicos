package com.example.Agendamento_Consultas.controllers;


import com.example.Agendamento_Consultas.entities.Client;
import com.example.Agendamento_Consultas.entities.Scheduling;
import com.example.Agendamento_Consultas.entities.Service;
import com.example.Agendamento_Consultas.repositories.ClientRepository;
import com.example.Agendamento_Consultas.repositories.SchedulingRepository;
import com.example.Agendamento_Consultas.repositories.ServiceRepository;
import com.example.Agendamento_Consultas.services.SchedulingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

    private final SchedulingService schedulingService;
    private final SchedulingRepository schedulingRepository;
    private final ServiceRepository serviceRepository;
    private final ClientRepository clientRepository;
    public SchedulingController(SchedulingService schedulingService, SchedulingRepository schedulingRepository, ServiceRepository serviceRepository, ClientRepository clientRepository) {
        this.schedulingService = schedulingService;
        this.schedulingRepository = schedulingRepository;
        this.serviceRepository = serviceRepository;
        this.clientRepository = clientRepository;
    }

    @PostMapping
    public Scheduling createScheduling(@RequestBody Scheduling scheduling) {
        if (scheduling.getService() != null && scheduling.getService().getTitle() != null) {
            Service service = serviceRepository.findByTitle(scheduling.getService().getTitle());

            if (service == null) {
                service = new Service(scheduling.getService().getTitle());
                serviceRepository.save(service);
            }
            scheduling.setService(service);
            scheduling.setPrice(scheduling.getPrice());
        }
        return schedulingRepository.save(scheduling);
    }

    @GetMapping
    public List<Scheduling> getAllSchedulings() {
        return schedulingRepository.findAll();
    }

    @GetMapping("{id}")
    public Scheduling getSchedulingById(@PathVariable Long id) {
        return schedulingRepository.findById(id).orElse(null);
    }

    @GetMapping("/client/{clientId}")
    public List<Scheduling> getSchedulingsByClient(@PathVariable Long clientId) {
        return schedulingRepository.findByClientId(clientId);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable Long id) {
        schedulingRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheduling> updateScheduling(@PathVariable Long id, @RequestBody Scheduling scheduling) {
        Optional<Scheduling> existingScheduling = schedulingRepository.findById(id);
        if (!existingScheduling.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Scheduling updateScheduling = existingScheduling.get();
        updateScheduling.setClient(scheduling.getClient());
        updateScheduling.setDate(scheduling.getDate());
        updateScheduling.setTime(scheduling.getTime());
        updateScheduling.setService(scheduling.getService());
        updateScheduling.setPrice(scheduling.getPrice());

        schedulingRepository.save(updateScheduling);

        return ResponseEntity.ok(updateScheduling);
    }

}
