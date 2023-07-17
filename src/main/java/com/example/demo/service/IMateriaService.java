package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Materia;

public interface IMateriaService {
	
	public Materia consultarCodigo(String codigo);
	
	public Materia consultarPorId(Integer id);
	
	public List<Materia > consultarTodos(String tipo);
	
	public void guardar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public void eliminar(Integer id);
	
	
	

}
