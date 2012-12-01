package com.proyecto.modelo;

import java.util.Collection;

public class Area {
	private String descripcion;
	
	//Un Area contiene varios Puestos
	private Collection<Puesto> listaPuestos;
	
	public Area() {
	}

	public Area(String descripcion) {
		super();
		
		this.descripcion = descripcion;
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
