package com.proyecto.modelo;

import java.util.Collection;

import com.proyecto.modelo.Rol;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private String passwordUsuario;
	private int idRol;

	// un Usuario puede Tener varios Roles
	private Collection<Rol> listaRoles;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombreUsuario,
			String passwordUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;	
		this.passwordUsuario = passwordUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
}
