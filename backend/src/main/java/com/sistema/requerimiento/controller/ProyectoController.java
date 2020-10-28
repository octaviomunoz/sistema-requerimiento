package com.sistema.requerimiento.controller;

import com.sistema.requerimiento.model.Proyecto;
import com.sistema.requerimiento.service.ProyectoService;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin
public class ProyectoController {

	private ProyectoService proyectoService;
	
	public ProyectoController(ProyectoService proyectoService) {
		this.proyectoService = proyectoService;
	}
	
	@PreAuthorize("hasRole('ROLE_JEFE_PROYECTO')")
	@GetMapping()
	public ResponseEntity<?> getProyectos(){
		List<Proyecto> listProyecto = proyectoService.getAll();
		
		if (listProyecto == null) {
			return new ResponseEntity<>("ERROR USUARIO NO EXISTE", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(listProyecto , HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ROLE_JEFE_PROYECTO')")
	@PutMapping()
	public ResponseEntity<?> modificarProyecto(@RequestBody Proyecto proyecto){
		Proyecto proyectoModificado = proyectoService.change(proyecto);
		
		if (proyectoModificado == null) {
			return new ResponseEntity<>("ERROR", HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<>(proyectoModificado, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_JEFE_PROYECTO')")
	@DeleteMapping("/{idProyecto")
	public ResponseEntity<?> eliminarProyecto(@PathVariable long idProyecto){
		proyectoService.delete(idProyecto);
		
		return new ResponseEntity<>("Proyecto fue Eliminado", HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_JEFE_PROYECTO')")
	@PostMapping("/crear")
	public ResponseEntity<?> saveProyecto(@RequestBody Proyecto proyecto){
		
		Proyecto newProyecto = proyectoService.save(proyecto);
		
		return new ResponseEntity<>(newProyecto, HttpStatus.OK);
	}
	
}
