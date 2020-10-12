package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Requisito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
@Component
public interface RequisitoRepository extends JpaRepository<Requisito, Long> {
    
}