package com.sistema.requerimiento.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SUBPROYECTOS")
public class Subproyecto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_proyecto")
    private Proyecto proyecto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_lider_subproyecto")
    private Usuario liderSubproyecto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_analista")
    private Usuario analista;

    @JsonIgnore
    @OneToMany(mappedBy = "subproyecto", cascade = CascadeType.ALL)
    private List<Requisito> requisitos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy="subproyecto", cascade = CascadeType.ALL)
    private List<Etiqueta> etiquetas = new ArrayList<>();

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

    public Proyecto getProyecto(){
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto){
        this.proyecto = proyecto;
    }

    public Usuario getLiderSubproyecto(){
        return this.liderSubproyecto;
    }

    public void setLiderSubproyecto(Usuario liderSubproyecto){
        this.liderSubproyecto = liderSubproyecto;
    }

    public Usuario getAnalista(){
        return this.analista;
    }

    public void setAnalista(Usuario analista){
        this.analista = analista;
    }

    public List<Requisito> getRequisitos(){
        return this.requisitos;
    }

    public void setRequisitos(List<Requisito> requisitos){
        this.requisitos = requisitos;
    }

    public List<Etiqueta> getEtiquetas(){
        return this.etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas){
        this.etiquetas = etiquetas;
    }

}