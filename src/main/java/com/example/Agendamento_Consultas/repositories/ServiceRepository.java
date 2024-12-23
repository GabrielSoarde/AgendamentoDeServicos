package com.example.Agendamento_Consultas.repositories;


import com.example.Agendamento_Consultas.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Optional<Service> findByTitle(String title);
}
