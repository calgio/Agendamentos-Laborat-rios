package com.spring.agendalab.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.spring.agendalab.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
	
	boolean existsByHoraInicio(String horaInicio);
}
