package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RoleRepository extends JpaRepository<Role, Long> {

}