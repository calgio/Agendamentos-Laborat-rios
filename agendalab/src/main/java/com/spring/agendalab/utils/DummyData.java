package com.spring.agendalab.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.agendalab.model.Agenda;
import com.spring.agendalab.repository.AgendaRepository;

@Component
public class DummyData {

    @Autowired
    AgendaRepository agendaRepository;

    //@PostConstruct
    public void savePosts(){

        List<Agenda> agendaList = new ArrayList<>();
        Agenda agenda1 = new Agenda();
        agenda1.setProfessor("Carlos");
        agenda1.setDisciplina("Bioinformatica");
        agenda1.setData_agendada("07/04/2020");
        agenda1.setHoraInicio("15:00");
        agenda1.setHoraTerminio("17:00");
       
        Agenda agenda2 = new Agenda();
        agenda2.setProfessor("Antonio");
        agenda2.setDisciplina("Metodologia de pesquisa");
        agenda2.setData_agendada("07/04/2020");
        agenda2.setHoraInicio("8:30");
        agenda2.setHoraTerminio("9:40");
        
        agendaList.add(agenda1);
        agendaList.add(agenda2);

        for(Agenda agenda: agendaList){
            Agenda agendaSaved = agendaRepository.save(agenda);
            System.out.println(agendaSaved.getId());
        }
    }
}
