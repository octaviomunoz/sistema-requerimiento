package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.RequisitoAsignado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RequisitoAsignadoRepository extends JpaRepository<RequisitoAsignado, Long> {
    
}