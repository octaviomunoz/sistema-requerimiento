package com.sistema.requerimiento.service.impl;

import com.sistema.requerimiento.repository.SubproyectoRepository;
import com.sistema.requerimiento.service.SubproyectoService;
import com.sistema.requerimiento.service.ProyectoService;
import com.sistema.requerimiento.service.UsuarioService;
import com.sistema.requerimiento.model.Subproyecto;
import com.sistema.requerimiento.model.Proyecto;
import com.sistema.requerimiento.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubproyectoServiceImpl implements SubproyectoService{

	private SubproyectoRepository subproyectoRepository;
	
	private ProyectoService proyectoService;
	
	private UsuarioService usuarioService;
	
	@Autowired
	public SubproyectoServiceImpl(SubproyectoRepository subproyectoRepository, ProyectoService proyectoService, UsuarioService usuarioService) {
		this.subproyectoRepository = subproyectoRepository;
		this.proyectoService = proyectoService;
		this.usuarioService = usuarioService;
	}
	
	public Subproyecto getSubproyecto(long id) {
		return subproyectoRepository.getOne(id);
	}
	
	public Subproyecto save(Subproyecto subproyecto, long idProyecto) {
		Proyecto proyecto = proyectoService.getProyecto(idProyecto);		
		subproyecto.setProyecto(proyecto);		
		return subproyectoRepository.save(subproyecto);		
	}
	
	//Elimina el subproyecto solo lo puede hacer el jefe de proyecto
	public void delete(long id) {
		if (isExist(id)) {
			Subproyecto subproyecto = subproyectoRepository.getOne(id);
			String rutJefeProyecto = SecurityContextHolder.getContext().getAuthentication().getName();
			if (subproyecto.getProyecto().getJefeProyecto().getRut() == rutJefeProyecto) {
				subproyectoRepository.delete(subproyecto);
			}
		}
	}
	
	public boolean isExist(long id) {
		return subproyectoRepository.existsById(id);
	}
	
	public Subproyecto change(Subproyecto subproyecto) {
		Subproyecto changeSubproyecto = subproyectoRepository.getOne(subproyecto.getId());
		if (changeSubproyecto == null) return null;
		
		changeSubproyecto.setNombre(subproyecto.getNombre());
		changeSubproyecto.setLiderSubproyecto(subproyecto.getLiderSubproyecto());
		changeSubproyecto.setAnalista(subproyecto.getAnalista());
		
		return subproyectoRepository.save(changeSubproyecto);
	}
	
	public List<Subproyecto> getAllUsuario(){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		Usuario liderSubproyecto = usuarioService.getUsuario(auth.getName());
		if (liderSubproyecto == null) return null;
		
		return subproyectoRepository.findByLiderSubproyecto(liderSubproyecto);
	}
	
	public List<Subproyecto> getAllProyecto(long idProyecto){
		Proyecto proyecto = proyectoService.getProyecto(idProyecto);
		
		return proyecto.getSubProyecto();
	}
}
