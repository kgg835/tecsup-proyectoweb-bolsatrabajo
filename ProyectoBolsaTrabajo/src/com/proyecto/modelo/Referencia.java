package com.proyecto.modelo;

public class Referencia {
	private int idReferencia;
	private String nombreReferencia;
	private String apellidoReferencia;
	private String email;
	private String telefonoReferencia;
	private String relacion;
	private String puestoEmpresa;
	private String experienciaRelacionada;
	//una Referencia pertenece a un Postulante
	private int codPostulante;

	// Get and Set
	public String getNombreReferencia() {
		return nombreReferencia;
	}

	public void setNombreReferencia(String nombreReferencia) {
		this.nombreReferencia = nombreReferencia;
	}

	public String getApellidoReferencia() {
		return apellidoReferencia;
	}

	public void setApellidoReferencia(String apellidoReferencia) {
		this.apellidoReferencia = apellidoReferencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefonoReferencia() {
		return telefonoReferencia;
	}

	public void setTelefonoReferencia(String telefonoReferencia) {
		this.telefonoReferencia = telefonoReferencia;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getPuestoEmpresa() {
		return puestoEmpresa;
	}

	public void setPuestoEmpresa(String puestoEmpresa) {
		this.puestoEmpresa = puestoEmpresa;
	}

	public String getExperienciaRelacionada() {
		return experienciaRelacionada;
	}

	public void setExperienciaRelacionada(String experienciaRelacionada) {
		this.experienciaRelacionada = experienciaRelacionada;
	}

	public void setIdReferencia(int idReferencia) {
		this.idReferencia = idReferencia;
	}

	public int getIdReferencia() {
		return idReferencia;
	}

	public void setCodPostulante(int codPostulante) {
		this.codPostulante = codPostulante;
	}

	public int getCodPostulante() {
		return codPostulante;
	}

}
