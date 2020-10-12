package com.sistema.requerimiento.controller.presentation;

import java.io.Serializable;

public class UsuarioResponse implements Serializable {

  private String rut;

  private String nombre;

  public UsuarioResponse(){

  }

  public String getRut(){
    return this.rut;
  }

  public void setRut(String rut){
    this.rut = rut;
  }

  public String getNombre(){
    return this.nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

}
