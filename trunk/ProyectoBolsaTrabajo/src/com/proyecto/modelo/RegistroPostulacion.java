package com.proyecto.modelo;

public class RegistroPostulacion {
private int idPostulacion;
private String fechPostulacion;
private String estadoPostulacion;



public RegistroPostulacion() {
	
}


public RegistroPostulacion(int idPostulacion, String fechPostulacion,
		String estadoPostulacion) {
	super();
	this.idPostulacion = idPostulacion;
	this.fechPostulacion = fechPostulacion;
	this.estadoPostulacion = estadoPostulacion;
}



public int getIdPostulacion() {
	return idPostulacion;
}



public void setIdPostulacion(int idPostulacion) {
	this.idPostulacion = idPostulacion;
}



public String getFechPostulacion() {
	return fechPostulacion;
}



public void setFechPostulacion(String fechPostulacion) {
	this.fechPostulacion = fechPostulacion;
}



public String getEstadoPostulacion() {
	return estadoPostulacion;
}



public void setEstadoPostulacion(String estadoPostulacion) {
	this.estadoPostulacion = estadoPostulacion;
}




}
