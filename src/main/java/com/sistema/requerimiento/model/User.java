package com.sistema.requerimiento.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column
    private String nombre;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = {
        @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;


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

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Set<Role> getRoles(){
        return this.roles;
    }

    public void getRoles(Set<Role> roles){
        this.roles = roles;
    }
}