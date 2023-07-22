package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepository;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public Estudiante consultarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}
	
	@Override
	public Estudiante consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarPorId(id);
	}

	@Override
	public List<Estudiante> consultarTodos(String provincia) {
		// TODO Auto-generated method stub
	return this.estudianteRepository.buscarTodos(provincia);
		
	}

	
	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.borrar(id);
	}

	@Override
	public Estudiante guardarModificado(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.insertarModificado(estudiante);
	}

	
	

	

}
