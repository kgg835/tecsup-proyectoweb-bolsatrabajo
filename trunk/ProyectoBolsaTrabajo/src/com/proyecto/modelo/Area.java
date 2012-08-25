package com.proyecto.modelo;

import java.util.Collection;

public class Area {
	private Integer codArea;
	private String descripcion;
	
	//Un Area contiene varios Puestos
	private Collection<Puesto> listaPuestos;
	
	public Area() {
	}

	public Area(Integer codArea, String descripcion) {
		super();
		this.codArea = codArea;
		this.descripcion = descripcion;
	}

	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setListaPuestos(Collection<Puesto> listaPuestos) {
		this.listaPuestos = listaPuestos;
	}

	public Collection<Puesto> getListaPuestos() {
		return listaPuestos;
	}

}
