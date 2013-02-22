package com.proyecto.modelo;

public class Estudio {
	private int idEstudios;
	private String tituloEstudio;
	private String fechaInicio;
	private String fechaFinal;
	private String descripcionInstutucion;
	private String pais;
	private String nivelEstudio;
	private String estado;
	private String areaEstudio;
	private double promedio;
	private int materiasAprovadas;
	private int cantidadMaterias;
	private int idPersona;
	private int idPresentacion;
	//un Estudio Pertenece a un Postulante
	private Postulante postulante;
	// Get and Set
	public int getIdEstudios() {
		return idEstudios;
	}

	public void setIdEstudios(int idEstudios) {
		this.idEstudios = idEstudios;
	}

	public String getTituloEstudio() {
		return tituloEstudio;
	}

	public void setTituloEstudio(String tituloEstudio) {
		this.tituloEstudio = tituloEstudio;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getDescripcionInstutucion() {
		return descripcionInstutucion;
	}

	public void setDescripcionInstutucion(String descripcionInstutucion) {
		this.descripcionInstutucion = descripcionInstutucion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAreaEstudio() {
		return areaEstudio;
	}

	public void setAreaEstudio(String areaEstudio) {
		this.areaEstudio = areaEstudio;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public int getMateriasAprovadas() {
		return materiasAprovadas;
	}

	public void setMateriasAprovadas(int materiasAprovadas) {
		this.materiasAprovadas = materiasAprovadas;
	}

	public int getCantidadMaterias() {
		return cantidadMaterias;
	}

	public void setCantidadMaterias(int cantidadMaterias) {
		this.cantidadMaterias = cantidadMaterias;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}

	public Postulante getPostulante() {
		return postulante;
	}
}
