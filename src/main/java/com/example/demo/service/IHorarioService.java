package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Horario;

public interface IHorarioService {

	public Horario consultarPorId(Integer id);

	public Horario consultarPorParalelo(String paralelo);

	public List<Horario> consultarTodos(String carrera);

	public void guardar(Horario horario);

	public void actualizar(Horario horario);

	public void eliminar(Integer id);

}
