package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	
	public Estudiante consultarCedula(String cedula);
	
	public Estudiante consultarPorId(Integer id);

	public void guardar(Estudiante estudiante);
	
	public Estudiante guardarModificado(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public void eliminar(Integer id);
	
	public List<Estudiante> consultarTodos(String provincia);
	
	public List<EstudianteTO> buscarTodosNormal();
	

	
}
