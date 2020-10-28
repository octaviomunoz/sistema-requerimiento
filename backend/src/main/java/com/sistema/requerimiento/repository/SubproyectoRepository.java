package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Subproyecto;
import com.sistema.requerimiento.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubproyectoRepository extends JpaRepository<Subproyecto, Long> {
    
	public List<Subproyecto> findByLiderSubproyecto(Usuario liderSubproyecto);
}