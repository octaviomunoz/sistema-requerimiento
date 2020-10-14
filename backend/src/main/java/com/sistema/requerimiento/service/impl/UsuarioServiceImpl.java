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
import java.util.List;


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
    Rol usuarioRol = rolRepository.findByNombre("USUARIO");

    Set<Rol> roles = new HashSet<>();

    roles.add(usuarioRol);

    usuario.setRol(roles);

    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario asignarRolProyecto(Usuario usuario){
    Rol jefeProyecto = rolRepository.findByNombre("JEFE_PROYECTO");
    Set<Rol> roles = usuario.getRol();
    roles.add(jefeProyecto);
    usuario.setRol(roles);
    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario asignarRolSubproyecto(Usuario usuario){
    Rol liderSubproyecto = rolRepository.findByNombre("LIDER_SUBPROYECTO");
    Set<Rol> roles = usuario.getRol();
    roles.add(liderSubproyecto);
    usuario.setRol(roles);
    return usuarioRepository.save(usuario);
  }

  @Override
  public Usuario asignarRolAnalista(Usuario usuario){
    Rol analista = rolRepository.findByNombre("ANALISTA");
    Set<Rol> roles = usuario.getRol();
    roles.add(analista);
    usuario.setRol(roles);
    return usuarioRepository.save(usuario);
  }

  @Override
  public List<Usuario> getAllUsuarios(){
    return usuarioRepository.findAll() ;
  }

}
