package com.example.Agendamento_Consultas.repositories;

import com.example.Agendamento_Consultas.entities.Client;
import com.example.Agendamento_Consultas.entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    Optional<Scheduling> findByDateAndTime(LocalDate date, LocalTime time);
    List<Scheduling> findByClient(Client client);
    List<Scheduling>findByClientId(Long client);

}
