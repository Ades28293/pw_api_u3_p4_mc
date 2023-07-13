package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {
	/*decimos al contenedor que va hacer un controller res atraves de este esteoriotipo
	Recibe a traves de la url mediante request o mas conocido como path a nivel de recurso atravez del 
	requestMapping el nombre de mi recurso debe hacer alusion ejemplo estudiante y debe estar en plural
	/estudiantes
*/
	
	//inyectamos el service para poder ocupar sus metodos
	@Autowired
	private IEstudianteService estudianteService;
	
	//el metodo debeG tener una direccion y debe estar instanciado el verbo ejemplo GET
	//anotacion GetMapping
	
	//una api esta apegado a un proyecto es la buena practica
	//debemos tener una api para cada dominio especifico ejemplo api tranferencia
	//microservisio con dominio especifico y ese nombre debe tener un nombre debemos ponerle
	//en le path
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula="1720757101";
		return this.estudianteService.consultarCedula(cedula);
	}
	
	@PostMapping(path ="/guardar" )
	public void guardar(@RequestBody Estudiante estudiante) { 
		//tiene estudiante reciba un estudiante ya necesitamos para guardar
		//dentro del request debe venir el estudiante debemos poner la anotación @RequestBody
		this.estudianteService.guardar(estudiante);
	}
	
	@PutMapping(path = "/actualizar")
	public void actualizar() {
		
	}
	
	@PatchMapping(path = "/actualizarParcial" )
	public void actualizarParcial() {
		
	}
	
	@DeleteMapping(path = "/borrar")
	public void borrar() {
		
	}
	
	
	
	
	
	
	
	
}
