package com.sistema.requerimiento.mapper;

import com.sistema.requerimiento.model.Rol;
import com.sistema.requerimiento.model.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

public class UsuarioDetailsMapper {

  public static UserDetails build(Usuario usuario) {

    return new org.springframework.security.core.userdetails.User(usuario.getRut(), usuario.getPassword(), getAuthorities(usuario));
  }

  public static Set<? extends GrantedAuthority> getAuthorities(Usuario usuario){

    Set<Rol> roles = usuario.getRol();

    Set<SimpleGrantedAuthority> authorities = new HashSet<>();

    roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getNombre())));

    return authorities;
  }
}
