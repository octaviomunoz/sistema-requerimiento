package com.sistema.requerimiento.controller;

import com.sistema.requerimiento.model.Usuario;
import com.sistema.requerimiento.service.UsuarioService;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioController{

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<?> getUsuarios(){
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
        
    }


    
}