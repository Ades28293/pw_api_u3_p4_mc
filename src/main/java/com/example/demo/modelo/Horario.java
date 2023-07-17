package com.example.demo.modelo;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_horario")
	@SequenceGenerator(name = "seq_horario",sequenceName = "seq_horario",allocationSize = 1)
	@Column(name = "hora_id")
	private Integer id;
	
	@Column(name = "hora_carrera")
	private String carrera;
	
	@Column(name = "hora_nivel")
	private String nivel;
	
	@Column(name = "hora_paralelo")
	private String paralelo;
	
	@Column(name = "hora_asignatura")
	private String asignatura;
	
	@Column(name = "hora_diaSemana")
	private String diaSemana;
	
	@Column(name = "hora_hora_inicio")
	private LocalTime horaInicio;
	
	@Column(name = "hora_hora_fin")
	private LocalTime horaFin;
	
	//Set y Get

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	
	
	
	
	
	
	

}
