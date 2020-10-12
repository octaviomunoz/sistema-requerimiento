package com.sistema.requerimiento.model;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="REQUISITOS")
public class Requisito {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String alias;

    private String descripcion;

    private String tipoFuncional;

    private String prioridad;

    private Date fechaCreacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_subproyecto")
    private Subproyecto subproyecto;

    @ManyToMany(mappedBy = "requisitos")
    private Set<Etiqueta> etiquetas;

    @JsonIgnore
    @OneToMany(mappedBy = "requisito", cascade = CascadeType.ALL)
    private List<VersionRequisito> versionesRequisito = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "requisito", cascade = CascadeType.ALL)
    private List<PropuestaCambio> propuestaCambio =  new ArrayList<>();

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

    public String getAlias(){
        return this.alias;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getTipoFuncional(){
        return this.tipoFuncional;
    }

    public void setTipoFuncional(String tipoFuncional){
        this.tipoFuncional = tipoFuncional;
    }

    public String getPrioridad(){
        return this.prioridad;
    }

    public void setPrioridad(String prioridad){
        this.prioridad = prioridad;
    }

    public Date getFechaCreacion(){
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public Subproyecto getSubproyecto(){
        return this.subproyecto;
    }

    public void setSubproyecto(Subproyecto subproyecto){
        this.subproyecto = subproyecto;
    }

    public Set<Etiqueta> getEtiquetas(){
        return this.etiquetas;
    }

    public void setEtiquetas(Set<Etiqueta> etiquetas){
        this.etiquetas = etiquetas;
    }

    public List<VersionRequisito> getVersionesRequisito(){
        return this.versionesRequisito;
    }

    public void setVersionesRequisitos(List<VersionRequisito> versionesRequisito){
        this.versionesRequisito = versionesRequisito;
    }

    public List<PropuestaCambio> getPropuestaCambio(){
        return this.propuestaCambio;
    }

    public void setPropuestaCambio(List<PropuestaCambio> propuestaCambio){
        this.propuestaCambio = propuestaCambio;
    }
}