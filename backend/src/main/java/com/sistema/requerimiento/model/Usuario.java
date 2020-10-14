package com.sistema.requerimiento.model;

import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String rut;

	private String nombre;
	
	@JsonIgnore
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_ROLES", joinColumns={
		@JoinColumn(name= "USER_ID") }, inverseJoinColumns = {
		@JoinColumn(name= "ROL_ID")	})
	private Set<Rol> roles;


	public Usuario(String rut, String nombre){
		this.rut = rut;
		this.nombre = nombre;
	}

	public Usuario(){

	}

	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRol() {
		return roles;
	}

	public void setRol(Set<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [rut=" + rut + ", nombre=" + nombre + ", password=" + password + ", rol=" + roles+ "]";
	}


}
