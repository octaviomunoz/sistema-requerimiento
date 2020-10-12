package com.sistema.requerimiento.repository;

import com.sistema.requerimiento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findByRut(String rut);

}
