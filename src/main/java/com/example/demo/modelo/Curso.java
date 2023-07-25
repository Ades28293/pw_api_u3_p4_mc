package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_curso") // anotacion de secuencia
	@SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", allocationSize = 1)
	@Column(name = "curs_id")
	private Integer id;
	
	@Column(name = "curs_nombre")
	private String nombre;
	
	@Column(name = "curs_codigo")
	private String codigo;
	
	@Column(name = "curs_numero_alumnos")
	private Integer numeroAlumnos;
	
	@Column(name = "curs_nivel_curso")
	private String nivelCurso;
	
	
	//SET Y GET
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getNumeroAlumnos() {
		return numeroAlumnos;
	}

	public void setNumeroAlumnos(Integer numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}

	public String getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}
	

	
	
	
	
	

}
