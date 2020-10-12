package com.sistema.requerimiento.controller.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AuthorizationRequest {

  @JsonProperty("rut")
  private String rut;

  @JsonProperty("pass")
  private String password;

  public AuthorizationRequest() {

  }

  public AuthorizationRequest(String rut, String password){
    this.rut = rut;
    this.password = password;
  }

  public String getRut(){
    return this.rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getPassword(){
    return this.password;
  }

  public void serPassword(String password){
    this.password = password;
  }

  @Override
  public String toString(){
    return "RUT : " + rut + ", PASSWORD : " + password;
  }

}
