package com.proyecto.modelo;

public class Postulante {
	private String codseleccion;
	private String email;
	private char sexo;
	private String fechaNacimiento;
	private String direccion;
	private String estadoCivil;
	private int telefonoFijo;
	private int telefonoCel;
	
	public Postulante(){}
	
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
	
	
}
