package com.spring.agendalab.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.agendalab.model.Agenda;
import com.spring.agendalab.services.AgendaServices;

@Controller
public class AgendaController {

	@Autowired
	AgendaServices agendaServices;
	
	@RequestMapping(value = "/agendas", method = RequestMethod.GET)
	public ModelAndView getAgenda() {
		
		ModelAndView mv = new ModelAndView("agendas");
		List<Agenda> agendas = agendaServices.findAll();
		mv.addObject("agendas", agendas);
		return mv;
		
	}	
	
	@RequestMapping(value = "/newAgenda", method = RequestMethod.GET)
	public String getNewAgenda() {
		return "newAgenda";
	}
	
	@RequestMapping(value = "/newAgenda", method = RequestMethod.POST)
	public String saveAgenda(@Valid Agenda agenda, @RequestParam(value = "horaInicio") String horaInicio, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem1", "Verifiquem se os campos obrigatorios foram preeenchidos! ");
			return "redirect:/newAgenda";
		}else if(agendaServices.existsByHoraInicio(horaInicio) == true) {
			attributes.addFlashAttribute("mensagem2", "Já existe agendamento nesse horario! ");
			return "redirect:/newAgenda";
		} else {
			agendaServices.save(agenda);
			attributes.addFlashAttribute("mensagem3", "Agendamento concluido! ");
			return "redirect:/newAgenda";
		}
	}
	
	@RequestMapping("/agenda/{id}")
	public String deleteAgenda(@PathVariable(name="id") Long id) {
		agendaServices.delete(id);
		return "redirect:/agendas";
	}
	
}
