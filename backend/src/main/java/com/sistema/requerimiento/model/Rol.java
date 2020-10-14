package com.sistema.requerimiento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="ROL")
public class Rol{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @JsonIgnore
  private long id;

  private String nombre;

  private String descripcion;


  public long getId(){
    return id;
  }

  public void setId(long id){
    this.id = id;
  }

  public String getNombre(){
    return nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public String getDescripcion(){
    return descripcion;
  }

  public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Rol [id=" + id +", nombre="+ nombre +"descripcion= "+descripcion+ "]";
  }


}
