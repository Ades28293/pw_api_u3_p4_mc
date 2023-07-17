package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Horario;

public interface IHorarioRepository {
	
	public Horario buscarPorId(Integer id);
	
	public Horario seleccionarPorParalelo(String paralelo);
	
	public List<Horario>buscarTodos(String carrera);
	
	public void insertar(Horario horario);
	
	public void actualizar(Horario horario);
	
	public void actualizarParcial(String paraleloActual,String paraleloNuevo);
	
	public void borrar(Integer id);
	

}
