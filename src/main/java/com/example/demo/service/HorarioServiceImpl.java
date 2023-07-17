package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Horario;
import com.example.demo.repository.IHorarioRepository;

@Service
public class HorarioServiceImpl implements IHorarioService{
	
	@Autowired
	private IHorarioRepository horarioRepository;

	@Override
	public Horario consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepository.buscarPorId(id);
	}

	@Override
	public Horario consultarPorParalelo(String paralelo) {
		// TODO Auto-generated method stub
		return this.horarioRepository.seleccionarPorParalelo(paralelo);
	}

	@Override
	public List<Horario> consultarTodos(String carrera) {
		// TODO Auto-generated method stub
		return this.horarioRepository.buscarTodos(carrera);
	}

	@Override
	public void guardar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.insertar(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		this.horarioRepository.borrar(id);
		
	}
	

}
