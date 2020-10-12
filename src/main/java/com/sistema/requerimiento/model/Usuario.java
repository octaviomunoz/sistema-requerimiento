package com.sistema.requerimiento.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String rut;

	private String nombre;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_ROLES", joinColumns={
		@JoinColumn(name= "USER_ID") }, inverseJoinColumns = {
		@JoinColumn(name= "ROL_ID")	})
	private Set<Rol> roles;


	public Usuario(String rut, String nombre){
		this.rut = rut;
		this.nombre = nombre;
		generadoPassword();
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

	private void generadoPassword() {
		this.password = this.nombre.substring(0, 3) + this.rut.substring(0, 3);
	}

	@Override
	public String toString() {
		return "Usuario [rut=" + rut + ", nombre=" + nombre + ", password=" + password + ", rol=" + roles+ "]";
	}


}
