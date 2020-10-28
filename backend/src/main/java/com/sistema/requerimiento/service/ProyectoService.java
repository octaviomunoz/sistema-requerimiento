package com.sistema.requerimiento.service;

import java.util.List;

import com.sistema.requerimiento.model.Proyecto;

public interface ProyectoService {
	
	Proyecto getProyecto(long id);
	
	Proyecto save(Proyecto proyecto);	
	
	void delete(long id);
	
	boolean isExist(long id);
	
	Proyecto change(Proyecto proyecto);
	
	List<Proyecto> getAll();
	
}
