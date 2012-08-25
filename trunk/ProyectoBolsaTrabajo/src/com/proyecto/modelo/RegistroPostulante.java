package com.proyecto.modelo;

import java.util.Collection;

public class RegistroPostulante {

	private int idRegPostulante;
	private String fecha;
	private String hora;
	
	// Un Registro de Postulante tiene de uno a muchos postulante
	private Collection<Postulante> listaRegistroPostulantes;

	public void setIdRegPostulante(int idRegPostulante) {
		this.idRegPostulante = idRegPostulante;
	}

	public int getIdRegPostulante() {
		return idRegPostulante;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getHora() {
		return hora;
	}

	public void setListaRegistroPostulantes(
			Collection<Postulante> listaRegistroPostulantes) {
		this.listaRegistroPostulantes = listaRegistroPostulantes;
	}

	public Collection<Postulante> getListaRegistroPostulantes() {
		return listaRegistroPostulantes;
	}
}
