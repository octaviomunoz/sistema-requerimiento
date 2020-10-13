package com.sistema.requerimiento.model;

import java.util.Date;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="REQUISITO_ASIGNADO")
public class RequisitoAsignado {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private Date fechaAsignacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_analista")
    private Usuario analista;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_requisito")
    private Requisito requisito;

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public Date getFechaAsignacion(){
        return this.fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion){
        this.fechaAsignacion = fechaAsignacion;
    }

    public Usuario getAnalista(){
        return this.analista;
    }

    public void setAnalista(Usuario analista){
        this.analista = analista;
    }

    public Requisito getRequisito(){
        return this.requisito;
    }

    public void setRequisito(Requisito requisito){
        this.requisito = requisito;
    }
}