package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Proyecto;
import com.sistema.requerimiento.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
	
	public List<Proyecto> findByJefeProyecto(Usuario JefeProyecto);
}