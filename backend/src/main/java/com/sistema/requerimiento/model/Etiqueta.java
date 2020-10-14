package com.sistema.requerimiento.model;

import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ETIQUETAS")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_subproyecto")
    private Subproyecto subproyecto;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "REQUISITO_ETIQUETA", 
        joinColumns = { @JoinColumn(name= "ETIQUETA_ID")}, 
        inverseJoinColumns = { @JoinColumn(name= "REQUISITO_ID") })
    private Set<Requisito> requisitos;

    
    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Subproyecto getSubproyecto(){
        return this.subproyecto;
    }

    public void setSubproyecto(Subproyecto subproyecto){
        this.subproyecto = subproyecto;
    }

    public Set<Requisito> getRequisitos(){
        return this.requisitos;
    }

    public void setRequisitos(Set<Requisito> Requisitos){
        this.requisitos = requisitos;
    }
}