package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping(path = "/{codigo}")
	public Materia consultarPorCodigo(@PathVariable String codigo) {

		return this.iMateriaService.consultarCodigo(codigo);
	}

	@GetMapping
	public List<Materia> consultarTodos(@RequestParam String tipo) {

		return this.iMateriaService.consultarTodos(tipo);
	}

	@PostMapping
	public void guardar(@RequestBody Materia materia) {

		this.iMateriaService.guardar(materia);

	}

	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {

		materia.setId(identificador);

		this.iMateriaService.actualizar(materia);
	}

	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {

		Materia mate1 = this.iMateriaService.consultarPorId(identificador);
		mate1.setCodigo(materia.getCodigo());

		this.iMateriaService.actualizar(mate1);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.iMateriaService.eliminar(id);
	}
	
	
	

}
