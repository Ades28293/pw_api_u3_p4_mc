package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	@GetMapping(path = "/{cedula}")
	public ResponseEntity<Estudiante>consultarPorCedula(@PathVariable String cedula) {
		//utilizamos un grapper para volver el objeto Estudiante -ResponseEntity
	
		return ResponseEntity.status(227).body(this.estudianteService.consultarCedula(cedula));
	}
	
	@GetMapping(path = "/status/{cedula}")
	public ResponseEntity<Estudiante>consultarPorCedulaStatus(@PathVariable String cedula) {
		//utilizamos un grapper para volver el objeto Estudiante -ResponseEntity
	
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarCedula(cedula));
	}
	
	@GetMapping
	public ResponseEntity<List<Estudiante>> consultartTodos(@RequestParam String provincia){
		//Request variable seleccionar un conjunto por medio de un criterio
		//buscarTodos?Provincia=provincia
		
		HttpHeaders cabeceras=new HttpHeaders();
		
		//se agrega una lista se puede agregar tantas cabeceras como las necesite
		//el primer parametro es la clave(id) para buscarle desde el front, el segundo el mensaje
		cabeceras.add("detalleMensaje", "Ciudadanos consultados exitosamente");
		cabeceras.add("valorApi", "Incalculable"); 
		
		//debo crear una instancia de responseEntity el primer parametro se manda la lista,segundo el mensaje,y el ultimo el codigo
		return  new ResponseEntity<>(this.estudianteService.consultarTodos(provincia),cabeceras,228);
		}
	

	
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) { 
		//tiene estudiante reciba un estudiante ya necesitamos para guardar
		//dentro del request debe venir el estudiante debemos poner la anotación @RequestBody
		this.estudianteService.guardar(estudiante);
	}
	
	//request pathvariable un identificador y debe estar puesto la anatocacion en el los parametros
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante,@PathVariable Integer identificador ) {
		estudiante.setId(identificador);		
		this.estudianteService.actualizar(estudiante);
	}
	
	@PatchMapping(path = "/{identificador}" )
	public void actualizarParcial(@RequestBody Estudiante estudiante,@PathVariable Integer identificador) {
		//solo se envia la cedula xq ese parametro le quiero actualizar para esto debemos hacer
		
		Estudiante estu1=this.estudianteService.consultarPorId(identificador);
		estu1.setCedula(estudiante.getCedula());
		
		this.estudianteService.actualizar(estu1);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		
		this.estudianteService.eliminar(id);
		
	}
	
	
	
	
	
	
	
	
	
	
}
