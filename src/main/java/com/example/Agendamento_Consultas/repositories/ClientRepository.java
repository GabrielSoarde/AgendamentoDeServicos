package com.example.Agendamento_Consultas.repositories;

import com.example.Agendamento_Consultas.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
