package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Curso;

public interface ICursoService {

	public void ingresar(Curso curso);
	
	public Curso consultarPorId(Integer id);
	
	public Curso consultarPorCodigo(String codigo);
	
	public List<Curso>consultarTodos(String nivelCurso);
	
	public void borrar(Integer id);
	
	public void actualizar(Curso curso);
	
	public void actualizarParcial(String codigoActual,String codigoNuevo);
}
