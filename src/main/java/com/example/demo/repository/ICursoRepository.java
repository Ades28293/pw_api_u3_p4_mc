package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Curso;

public interface ICursoRepository {
	
	public void insertar(Curso curso);
	
	public Curso buscarPorId(Integer id);
	
	public Curso buscarPorCodigo(String codigo);
	
	public void eliminar(Integer id);
	
	public void actualizar(Curso curso);
	
	public List<Curso>buscarTodos(String nivelCurso);
	
	public void actualizarParcial(String codigoActual,String codigoNuevo);
	
	

	
	

}
