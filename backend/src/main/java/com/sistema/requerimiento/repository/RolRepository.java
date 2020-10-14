package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RolRepository extends JpaRepository<Rol, Long> {

  Rol getRolById(long id);

  Rol findByNombre(String nombre);

}
