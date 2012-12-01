package com.proyecto.modelo;

public class ExperienciaLaboral {
	private int idExperienciaLaboral;
	private int idPostulante;
	private String tituloPuesto;
	private String empresa;
	private String pais;
	private String fechaInicio;
	private String fechaFinal;
	private String area;
	private String subArea;
	private String descripcionResponsabilidad;
	private int numPersonasCargo;
	//Una Experiencia Laboral pertenece a un Postulante
	private Postulante postulante;
	
	//Get and Set
	public int getIdExperienciaLaboral() {
		return idExperienciaLaboral;
	}
	public void setIdExperienciaLaboral(int idExperienciaLaboral) {
		this.idExperienciaLaboral = idExperienciaLaboral;
	}
	public String getTituloPuesto() {
		return tituloPuesto;
	}
	public void setTituloPuesto(String tituloPuesto) {
		this.tituloPuesto = tituloPuesto;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSubArea() {
		return subArea;
	}
	public void setSubArea(String subArea) {
		this.subArea = subArea;
	}
	public String getDescripcionResponsabilidad() {
		return descripcionResponsabilidad;
	}
	public void setDescripcionResponsabilidad(String descripcionResponsabilidad) {
		this.descripcionResponsabilidad = descripcionResponsabilidad;
	}
	public int getNumPersonasCargo() {
		return numPersonasCargo;
	}
	public void setNumPersonasCargo(int numPersonasCargo) {
		this.numPersonasCargo = numPersonasCargo;
	}
	public void setPostulante(Postulante postulante) {
		this.postulante = postulante;
	}
	public Postulante getPostulante() {
		return postulante;
	}
	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}
	public int getIdPostulante() {
		return idPostulante;
	}
	
	
}
