package com.sistema.requerimiento.model;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "VERSION_REQUISITO")
public class VersionRequisito {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nombreRequisito;

    private String nombreAnalista;

    private String nombreSubproyecto;

    private String nombreProyecto;
    
    private String alias;

    private String descripcion;

    private String tipoFuncional;

    private Date fechaCreacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "id_requisito")
    private Requisito requisito;

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getNombreRequisito(){
        return this.nombreRequisito;
    }

    public void setNombreRequisito(String nombreRequisito){
        this.nombreRequisito = nombreRequisito;
    }

    public String getNombreAnalista(){
        return this.nombreAnalista;
    }

    public void setNombreAnalista(String nombreAnalista){
        this.nombreAnalista = nombreAnalista;
    }

    public String getNombreSubproyecto(){
        return this.nombreSubproyecto;
    }

    public void setNombreSubproyecto(String nombreSubproyecto){
        this.nombreSubproyecto = nombreSubproyecto;
    }

    public String getNombreProyecto(){
        return this.nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto){
        this.nombreProyecto = nombreProyecto;
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

    public Date getFechaCreacion(){
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
}