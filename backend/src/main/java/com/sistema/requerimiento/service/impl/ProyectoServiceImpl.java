package com.sistema.requerimiento.service.impl;

import com.sistema.requerimiento.repository.ProyectoRepository;
import com.sistema.requerimiento.service.ProyectoService;
import com.sistema.requerimiento.model.Proyecto;
import com.sistema.requerimiento.model.Usuario;
import com.sistema.requerimiento.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	private ProyectoRepository proyectoRepository;
	
	private UsuarioService usuarioService;
	
	@Autowired
	public ProyectoServiceImpl(ProyectoRepository proyectoRepository, UsuarioService usuarioService) {
		this.proyectoRepository = proyectoRepository;
		this.usuarioService = usuarioService;
	}
	
	
	@Override
	public Proyecto getProyecto(long id){
		return proyectoRepository.getOne(id);
	}
	
	@Override
	public Proyecto save(Proyecto proyecto) {
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		
		proyecto.setJefeProyecto(usuarioService.getUsuario(auth.getName()));		
		return proyectoRepository.save(proyecto);		
	}
	
	@Override	
	public void delete(long id) {
		Proyecto proyecto = proyectoRepository.getOne(id);
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		
		//Si existe el proyecto lo elimina y que el proyecto sea del jefe de proyecto
		if (proyecto != null && proyecto.getJefeProyecto().getRut() == auth.getName()) {
			proyectoRepository.delete(proyecto);
		}
	}
	
	@Override
	public Proyecto change(Proyecto proyecto) {
		Proyecto changeProyecto = proyectoRepository.getOne(proyecto.getId());
		if (changeProyecto == null) {
			return null;
		}
		
		changeProyecto.setNombre(proyecto.getNombre());
		changeProyecto.setJefeProyecto(proyecto.getJefeProyecto());
		changeProyecto.setSubProyecto(proyecto.getSubProyecto());
		
		return proyectoRepository.save(changeProyecto);
	}
	
	//Devuelve una lista de todos los proyectos que posee el usuario
	@Override
	public List<Proyecto> getAll(){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		Usuario jefeProyecto = usuarioService.getUsuario(auth.getName());
		if (jefeProyecto == null) return null;
		
		return proyectoRepository.findByJefeProyecto(jefeProyecto);
	}
	
	@Override
	public boolean isExist(long id) {
		return proyectoRepository.existsById(id);
	}
	
	
}
