package com.proyecto.modelo;

public class RegistroPostulacion {
	private int idPostulacion;
	private String fecha;
	private String hora;
	
	//Un Registro de Postulacion contiene a un postulante
	private Postulante postulante;

	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}
	
	//Get and Set
	public Postulante getPostulante() {
		return postulante;
	}

	public void setIdPostulacion(int idPostulacion) {
		this.idPostulacion = idPostulacion;
	}

	public int getIdPostulacion() {
		return idPostulacion;
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
}
