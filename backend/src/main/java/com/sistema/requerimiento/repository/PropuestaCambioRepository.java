package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.PropuestaCambio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PropuestaCambioRepository extends JpaRepository<PropuestaCambio, Long> {

}