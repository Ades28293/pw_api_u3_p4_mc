package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IMateriaService;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;
	
	
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MateriaTO consultarPorId(@PathVariable Integer id) {
		return this.iMateriaService.consultarPorId(id);
	}
	

//	@GetMapping(path = "/{codigo}")
//	public Materia consultarPorCodigo(@PathVariable String codigo) {
//
//		return this.iMateriaService.consultarCodigo(codigo);
//	}
//
//	@GetMapping
//	public List<Materia> consultarTodos(@RequestParam String tipo) {
//
//		return this.iMateriaService.consultarTodos(tipo);
//	}
//
//	@PostMapping
//	public void guardar(@RequestBody Materia materia) {
//
//		this.iMateriaService.guardar(materia);
//
//	}
//
//	@PutMapping(path = "/{identificador}")
//	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
//
//		materia.setId(identificador);
//
//		this.iMateriaService.actualizar(materia);
//	}
//
//	@PatchMapping(path = "/{identificador}")
//	public void actualizarParcial(@RequestBody Materia materia, @PathVariable Integer identificador) {
//
//		Materia mate1 = this.iMateriaService.consultarPorId(identificador);
//		mate1.setCodigo(materia.getCodigo());
//
//		this.iMateriaService.actualizar(mate1);
//	}
//	
//	
//	@DeleteMapping(path = "/{id}")
//	public void borrar(@PathVariable Integer id) {
//		this.iMateriaService.eliminar(id);
//	}
	
	
	

}
