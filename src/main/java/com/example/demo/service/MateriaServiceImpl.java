package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Materia;
import com.example.demo.repository.IMateriaRepository;

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

}
