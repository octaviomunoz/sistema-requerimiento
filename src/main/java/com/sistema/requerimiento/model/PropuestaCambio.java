package com.sistema.requerimiento.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PROPUESTA_CAMBIO")
public class PropuestaCambio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String comentario;

    private String estado; //En espera o Aprobado

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_requisito")
    private Requisito requisito;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getComentario(){
        return this.comentario;
    }

    public void setComentario(String comentario){
        this.comentario = comentario;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public Requisito getRequisito(){
        return this.requisito;
    }

    public void setRequisito(Requisito requisito){
        this.requisito = requisito;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}