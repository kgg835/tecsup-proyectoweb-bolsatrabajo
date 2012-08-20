package com.proyecto.modelo;

public class Area {
	private Integer codArea;
	private String descripcion;

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

}
