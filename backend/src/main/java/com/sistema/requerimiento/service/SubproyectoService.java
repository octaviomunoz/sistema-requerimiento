package com.sistema.requerimiento.service;

import java.util.List;
import com.sistema.requerimiento.model.Subproyecto;


public interface SubproyectoService {

	Subproyecto getSubproyecto(long id);
	
	Subproyecto save(Subproyecto subproyecto, long idProyecto);
	
	void delete(long id);
	
	boolean isExist(long id);
	
	Subproyecto change(Subproyecto subproyecto);
	
	List<Subproyecto> getAllUsuario();
	
	List<Subproyecto> getAllProyecto(long idProyecto);
}
