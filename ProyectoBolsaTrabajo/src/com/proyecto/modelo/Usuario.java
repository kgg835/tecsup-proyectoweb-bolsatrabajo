package com.proyecto.modelo;

import java.util.Collection;

import com.proyecto.modelo.Rol;

public class Usuario {
	private String nombreUsuario;
	private String codUsuario;
	private String passwordUsuario;

	// un Usuario puede Tener varios Roles
	private Collection<Rol> listaRoles;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombreUsuario, String codUsuario,
			String passwordUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.codUsuario = codUsuario;
		this.passwordUsuario = passwordUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public void setListaRoles(Collection<Rol> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public Collection<Rol> getListaRoles() {
		return listaRoles;
	}
}
