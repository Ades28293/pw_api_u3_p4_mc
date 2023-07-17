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

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFul {
	
	@Autowired
	private IHorarioService horarioService;
	
	@GetMapping(path = "/{paralelo}")
	public Horario consultarPorParalelo(@PathVariable String paralelo) {
		return this.horarioService.consultarPorParalelo(paralelo);
	}
	
	//RequestParam lista de horarios
	@GetMapping
	private List<Horario> consultarTodos(@RequestParam String carrera){
		return this.horarioService.consultarTodos(carrera);
	}
	
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.horarioService.guardar(horario);
	}
	
	@PutMapping(path = "/{id}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer id) {
		
		horario.setId(id);
		this.horarioService.actualizar(horario);
		
	}
	
	@PatchMapping(path = "/{identificador}" )
	public void actualizarParcial(@RequestBody Estudiante estudiante,@PathVariable Integer identificador) {
		//solo se envia la cedula xq ese parametro le quiero actualizar para esto debemos hacer
		
		Horario hora1=this.horarioService.consultarPorId(identificador);
		hora1.setParalelo(hora1.getParalelo());
		
		this.horarioService.actualizar(hora1);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		
		this.horarioService.eliminar(id);
		
	}
	

}
