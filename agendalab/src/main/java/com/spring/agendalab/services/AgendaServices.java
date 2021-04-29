package com.spring.agendalab.services;

import java.util.List;

import com.spring.agendalab.model.Agenda;

public interface AgendaServices {
	
	List<Agenda> findAll();
	Agenda findById(long id);
	Agenda save(Agenda agenda);
	void delete(long id);
	boolean existsByHoraInicio(String horaInicio);
}
