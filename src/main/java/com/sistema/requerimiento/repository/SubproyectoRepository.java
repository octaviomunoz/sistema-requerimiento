package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Subproyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SubproyectoRepository extends JpaRepository<Subproyecto, Long> {
    
}