package com.sistema.requerimiento.mapper;

import com.sistema.requerimiento.model.Usuario;
import com.sistema.requerimiento.controller.presentation.AuthorizationRequest;
import com.sistema.requerimiento.controller.presentation.UsuarioResponse;

public class UsuarioMapper {

  public static UsuarioResponse toResponse(Usuario usuario){
    UsuarioResponse usuarioresponse = new UsuarioResponse();
    usuarioresponse.setRut(usuario.getRut());
    usuarioresponse.setNombre(usuario.getNombre());

    return usuarioresponse;
  }


  public static Usuario toDomain(AuthorizationRequest authorizationRequest) {
    Usuario usuario = new Usuario();

    usuario.setRut(authorizationRequest.getRut());
    usuario.setPassword(authorizationRequest.getPassword());

    return usuario;
  }

}
