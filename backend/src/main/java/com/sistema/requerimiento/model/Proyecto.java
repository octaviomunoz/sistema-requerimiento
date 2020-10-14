package com.sistema.requerimiento.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="PROYECTOS")
public class Proyecto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;   

    private String nombre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_jefe_proyecto")
    private Usuario jefeProyecto;

    @JsonIgnore
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL)
    private List<Subproyecto> subproyecto = new ArrayList<>();

    public long getId(){
        return this.id;
    }

    public void setId(){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Usuario getJefeProyecto(){
        return this.jefeProyecto;
    }

    public void setJefeProyecto(Usuario jefeProyecto){
        this.jefeProyecto = jefeProyecto;
    }

    public List<Subproyecto> getSubProyecto() {
        return this.subproyecto;
    }

    public void setSubProyecto(List<Subproyecto> subproyecto){
        this.subproyecto = subproyecto;
    }
}