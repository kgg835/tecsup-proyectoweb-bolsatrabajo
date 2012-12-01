package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String nombreUsuario;

	private String passwordUsuario;

	//bi-directional many-to-one association to Ofertante
	@OneToMany(mappedBy="usuario")
	private Set<Ofertante> ofertantes;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="usuario")
	private Set<Persona> personas;

	//bi-directional many-to-one association to Rol
    @ManyToOne
	@JoinColumn(name="idROL")
	private Rol rol;

    public Usuario() {
    }

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPasswordUsuario() {
		return this.passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public Set<Ofertante> getOfertantes() {
		return this.ofertantes;
	}

	public void setOfertantes(Set<Ofertante> ofertantes) {
		this.ofertantes = ofertantes;
	}
	
	public Set<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}
	
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}