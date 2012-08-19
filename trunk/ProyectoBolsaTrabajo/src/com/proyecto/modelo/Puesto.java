package com.proyecto.modelo;

public class Puesto {
	private String nombrePuesto;
	private String descripcion;
	private Integer codArea;
	
	public Puesto(){}
	
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
	
	
}
