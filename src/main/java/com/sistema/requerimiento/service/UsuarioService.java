package com.sistema.requerimiento.service;

import com.sistema.requerimiento.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

  Usuario getUsuario(String rut);

  Usuario save(Usuario usuario);
}
