package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

}