package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.VersionRequisito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VersionRequisitoRepository extends JpaRepository<VersionRequisito, Long> {

}