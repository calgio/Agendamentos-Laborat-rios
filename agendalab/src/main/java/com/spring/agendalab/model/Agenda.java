package com.spring.agendalab.model;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_AGENDA")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String professor;
	
	@NotBlank
	private String disciplina;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date dataAgendada;
	
	@NotBlank
	private String horaInicio;
	
	@NotBlank
	private String horaTerminio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Date getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(Date dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTerminio() {
		return horaTerminio;
	}

	public void setHoraTerminio(String horaTerminio) {
		this.horaTerminio = horaTerminio;
	}

	public void setData_agendada(String string) {
		// TODO Auto-generated method stub
		
	}
	
		
}
