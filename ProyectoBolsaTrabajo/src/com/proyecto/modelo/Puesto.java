package com.proyecto.modelo;

import java.util.Collection;

public class Puesto {
	private String nombrePuesto;
	private String descripcion;
	private Integer codArea;
	//Un Puesto puede estar en Varios Avisos
	private Collection<Aviso> listaAvisos;
	public Puesto() {
	}

	public Puesto(String nombrePuesto, String descripcion, Integer codArea) {
		super();
		this.nombrePuesto = nombrePuesto;
		this.descripcion = descripcion;
		this.codArea = codArea;
	}

	public String getNombrePuesto() {
		return nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	public void setListaAvisos(Collection<Aviso> listaAvisos) {
		this.listaAvisos = listaAvisos;
	}

	public Collection<Aviso> getListaAvisos() {
		return listaAvisos;
	}

}
