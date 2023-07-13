package com.example.demo.service;

import com.example.demo.modelo.Materia;

public interface IMateriaService {
	
	public Materia consultarCodigo(String codigo);
	
	public void guardar(Materia materia);

}
