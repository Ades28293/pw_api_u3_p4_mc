package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Materia;
import com.example.demo.service.to.MateriaTO;

public interface IMateriaService {
	
	public Materia consultarCodigo(String codigo);
	
	public MateriaTO consultarPorId(Integer id);
	
	public List<Materia > consultarTodos(String tipo);
	
	public void guardar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public void eliminar(Integer id);
	
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula);
	
	
	

}
