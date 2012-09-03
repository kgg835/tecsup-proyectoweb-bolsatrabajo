package com.proyecto.modelo;

import java.util.Collection;

public class Postulante extends Persona {
	private String codseleccion;
	private String email;
	private char sexo;
	private String fechaNacimiento;
	private String direccion;
	private String estadoCivil;
	private int telefonoFijo;
	private int telefonoCel;

	// Un postulante tiene un Registro de Postulante
	//private RegistroPostulante registroPostulante;

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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
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

	public int getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(int telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public int getTelefonoCel() {
		return telefonoCel;
	}

	public void setTelefonoCel(int telefonoCel) {
		this.telefonoCel = telefonoCel;
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

	public void setListaAvisos(Collection<Aviso> listaAvisos) {
		this.listaAvisos = listaAvisos;
	}

	public Collection<Aviso> getListaAvisos() {
		return listaAvisos;
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
