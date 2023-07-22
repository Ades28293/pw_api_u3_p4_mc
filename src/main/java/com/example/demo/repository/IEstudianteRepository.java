package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepository {
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public Estudiante buscarPorId(Integer id);
	
	public void insertar(Estudiante estudiante);
	
	public Estudiante insertarModificado(Estudiante estudiante);
	
	public void actualizar(Estudiante estudiante);
	
	public void actualizarParcial(String cedulaActual,String cedulaNueva);
	
	public void borrar(Integer id);
	
	public List<Estudiante> buscarTodos(String provincia);
	
	

}
