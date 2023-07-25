package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Curso;
import com.example.demo.service.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoControllerRestFul {
	
	@Autowired
	private ICursoService cursoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void ingresar(@RequestBody Curso curso) {
		
		this.cursoService.ingresar(curso);
	}
	
	
	@GetMapping(path = "/{codigo}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	private Curso consultarPorCodigo(@PathVariable String codigo){
	
		return this.cursoService.consultarPorCodigo(codigo);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> cunsultarTodos(@RequestParam String nivelCurso){
		
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("detalleMensaje", "Cursos consultados exitosamente");
		
		
		return new ResponseEntity<>(this.cursoService.consultarTodos(nivelCurso),cabeceras,200);
	}
	
	@DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void borrar(@PathVariable Integer id) {
		this.cursoService.borrar(id);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizar(@RequestBody Curso curso,@PathVariable Integer id) {
		curso.setId(id);
		this.cursoService.actualizar(curso);
	}
	
	@PatchMapping(path = "/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void actualizarParcial(@RequestBody Curso curso, @PathVariable String codigo) {
		Curso cursoAux = this.cursoService.consultarPorCodigo(codigo);
		this.cursoService.actualizarParcial(cursoAux.getCodigo(), curso.getCodigo());
	}
	
	

}
