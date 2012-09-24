package com.proyecto.modelo;

import java.util.Collection;

public class Postulante extends Persona {
	private int idPostulante;
	private String codseleccion;
	private String email;
	private String sexo;
	private String fechaNacimiento;
	private String direccion;
	private String estadoCivil;
	private String telefonoFijo;
	private String telefonoCel;
	private String passwordPE;


	// Un postulante tiene un registro de login
//	private Login loginPostulante;

	// Un postulante puede consultar de 0 a muchos Avisos
	private Collection<Aviso> listaAvisos;

	// Un postulante tiene de 0 a muchas postulaciones
	//private Collection<RegistroPostulacion> listaregistroPostulacion;

	// Un postulante es una Persona
	public Postulante() {
		super();
	}

	public Postulante(String codseleccion) {
		super();
		this.codseleccion = codseleccion;
	}

	public String getCodseleccion() {
		return codseleccion;
	}

	public void setCodseleccion(String codseleccion) {
		this.codseleccion = codseleccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	
//	public void setRegistroPostulante(RegistroPostulante registroPostulante) {
//		this.registroPostulante = registroPostulante;
//	}
//
//	public RegistroPostulante getRegistroPostulante() {
//		return registroPostulante;
//	}

//	public void setLoginPostulante(Login loginPostulante) {
//		this.loginPostulante = loginPostulante;
//	}
//
//	public Login getLoginPostulante() {
//		return loginPostulante;
//	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoCel() {
		return telefonoCel;
	}

	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public void setListaAvisos(Collection<Aviso> listaAvisos) {
		this.listaAvisos = listaAvisos;
	}

	public Collection<Aviso> getListaAvisos() {
		return listaAvisos;
	}

	public String getPasswordPE() {
		return passwordPE;
	}

	public void setPasswordPE(String passwordPE) {
		this.passwordPE = passwordPE;
	}

//	public void setListaregistroPostulacion(
//			Collection<RegistroPostulacion> listaregistroPostulacion) {
//		this.listaregistroPostulacion = listaregistroPostulacion;
//	}
//
//	public Collection<RegistroPostulacion> getListaregistroPostulacion() {
//		return listaregistroPostulacion;
//	}

}