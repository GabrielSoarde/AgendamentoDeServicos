package com.example.Agendamento_Consultas.repositories;


import com.example.Agendamento_Consultas.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByTitle(String title);
}
