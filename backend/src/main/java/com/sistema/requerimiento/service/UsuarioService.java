package com.sistema.requerimiento.service;

import java.util.List;

import com.sistema.requerimiento.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

  Usuario getUsuario(String rut);

  Usuario save(Usuario usuario);

  Usuario asignarRolProyecto(Usuario usuario);

  Usuario asignarRolSubproyecto(Usuario usuario);

  Usuario asignarRolAnalista(Usuario usuario);

  List<Usuario> getAllUsuarios();

}
