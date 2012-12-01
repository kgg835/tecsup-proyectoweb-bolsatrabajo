package com.proyecto.modelo;

import java.util.Collection;

public class Rol {
	private int rolId;
	private String tipoRol;
	private String codRol;
	// Rol Puede tener varios Usuarios
	private Collection<Usuario> listaUsuarios;

	public Rol(String tipoRol, String codRol) {
		super();
		this.tipoRol = tipoRol;
		this.codRol = codRol;
	}

	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	public String getCodRol() {
		return codRol;
	}

	public void setCodRol(String codRol) {
		this.codRol = codRol;
	}

	public void setListaUsuarios(Collection<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Collection<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public int getRolId() {
		return rolId;
	}
}
