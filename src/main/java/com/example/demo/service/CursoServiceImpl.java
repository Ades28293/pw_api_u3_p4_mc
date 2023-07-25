package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Curso;
import com.example.demo.repository.ICursoRepository;

@Service
public class CursoServiceImpl implements ICursoService{
	
	@Autowired
	private ICursoRepository cursoRepository;
	
	@Override
	public void ingresar(Curso curso) {
		// TODO Auto-generated method stub
		this.cursoRepository.insertar(curso);
	}

	@Override
	public Curso consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.cursoRepository.buscarPorId(id);
	}

	@Override
	public Curso consultarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.cursoRepository.buscarPorCodigo(codigo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.cursoRepository.eliminar(id);
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		this.cursoRepository.actualizar(curso);
	}

	@Override
	public List<Curso> consultarTodos(String nivelCurso) {
		// TODO Auto-generated method stub
		return this.cursoRepository.buscarTodos(nivelCurso);
	}

	@Override
	public void actualizarParcial(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		this.cursoRepository.actualizarParcial(codigoActual, codigoNuevo);
	}

}
