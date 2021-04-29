package com.spring.agendalab.services.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.agendalab.model.Agenda;
import com.spring.agendalab.repository.AgendaRepository;
import com.spring.agendalab.services.AgendaServices;

@Service
public class AgendaServicesImpl implements AgendaServices{

	@Autowired
	AgendaRepository agendaRepository;
	
	@Override
	public List<Agenda> findAll() {
		
		return agendaRepository.findAll();
	}

	@Override
	public Agenda findById(long id) {
		
		return agendaRepository.findById(id).get();
	}

	@Override
	public Agenda save(Agenda agenda) {
		
		return agendaRepository.save(agenda);
	}

	@Override
	public void delete(long id) {
		agendaRepository.deleteById(id);		
	}

	@Override
	public boolean existsByHoraInicio(String horaInicio) {
		return agendaRepository.existsByHoraInicio(horaInicio);
	}

}
