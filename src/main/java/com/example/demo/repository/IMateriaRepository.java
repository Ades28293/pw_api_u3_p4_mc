package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Materia;

public interface IMateriaRepository {
	
	public Materia seleccionarPorCodigo(String codigo);
	
	public Materia buscarPorId(Integer id);
	
	public List<Materia> buscarTodos(String tipo);
	
	public void insertar(Materia materia);
	
	public void actualizar(Materia materia);
	
	public void actualizarParcial(String codigoActual,String codigoNueva);
	
	public void borrar(Integer id);
	
	

}
