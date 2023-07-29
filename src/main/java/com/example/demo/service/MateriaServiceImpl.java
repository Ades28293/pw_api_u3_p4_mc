package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Materia;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public Materia consultarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}

	@Override
	public MateriaTO consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.convertir(this.iMateriaRepository.buscarPorId(id));
	}

	@Override
	public List<Materia> consultarTodos(String tipo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarTodos(tipo);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizar(materia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.borrar(id);
	}
	
	@Override
	public List<MateriaTO> buscarPorCedulaEstudiante(String cedula) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarPorCedulaEstudiante(cedula).stream().map(mat -> this.convertir(mat))
				.collect(Collectors.toList());
	}

	private MateriaTO convertir(Materia materia) {

		MateriaTO matTO = new MateriaTO();

		matTO.setId(materia.getId());
		matTO.setNombre(materia.getNombre());
		matTO.setCodigo(materia.getCodigo());
		matTO.setNumeroCreditos(materia.getNumeroCreditos());
		matTO.setTipo(materia.getTipo());

		return matTO;
	}
	

}
