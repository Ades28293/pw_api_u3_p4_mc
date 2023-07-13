package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping(path = "/buscar")
	public Materia consultarPorCodigo() {

		String codigo = "PWP408";

		return this.iMateriaService.consultarCodigo(codigo);
	}
	
	@PostMapping(path = "/guardar")
	private void guardar(@RequestBody Materia materia) {
		
		this.iMateriaService.guardar(materia);
		
	}

}
