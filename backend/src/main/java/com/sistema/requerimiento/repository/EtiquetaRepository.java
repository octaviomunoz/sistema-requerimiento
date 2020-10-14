package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Etiqueta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    
}