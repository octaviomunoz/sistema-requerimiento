package com.sistema.requerimiento.service.impl;

import com.sistema.requerimiento.model.Usuario;
import com.sistema.requerimiento.model.Rol;
import com.sistema.requerimiento.mapper.UsuarioDetailsMapper;
import com.sistema.requerimiento.repository.UsuarioRepository;
import com.sistema.requerimiento.repository.RolRepository;
import com.sistema.requerimiento.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("usuarioDetailsService")
public class UsuarioServiceImpl implements UsuarioService {

  private RolRepository rolRepository;

  private UsuarioRepository usuarioRepository;

  @Autowired
  public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
    this.usuarioRepository = usuarioRepository;
    this.rolRepository = rolRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    final Usuario retrieveUsuario = usuarioRepository.findByRut(userName);

    if (retrieveUsuario == null){

      throw new UsernameNotFoundException("Rut o Contraseña Invalido");
    }

    return UsuarioDetailsMapper.build(retrieveUsuario);

  }

  @Override
  public Usuario getUsuario(String rut){
    return usuarioRepository.findByRut(rut);
  }

  @Override
  public Usuario save(Usuario usuario){
    Rol usuarioRol = rolRepository.findByNombre("USER");

    Set<Rol> roles = new HashSet<>();

    roles.add(usuarioRol);

    usuario.setRol(roles);

    return usuarioRepository.save(usuario);
  }




}
