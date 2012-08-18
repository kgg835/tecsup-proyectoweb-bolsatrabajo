package com.proyecto.modelo;

public class Ofertante {
private String codofertante;
private String ruc;
private String razonsocial;
private String correo;
private String contraseña;
private String descempresa;

public Ofertante(){}

public Ofertante(String codofertante, String ruc, String razonsocial,
		String correo, String contraseña, String descempresa) {
	super();
	this.codofertante = codofertante;
	this.ruc = ruc;
	this.razonsocial = razonsocial;
	this.correo = correo;
	this.contraseña = contraseña;
	this.descempresa = descempresa;
}

public String getCodofertante() {
	return codofertante;
}

public void setCodofertante(String codofertante) {
	this.codofertante = codofertante;
}

public String getRuc() {
	return ruc;
}

public void setRuc(String ruc) {
	this.ruc = ruc;
}

public String getRazonsocial() {
	return razonsocial;
}

public void setRazonsocial(String razonsocial) {
	this.razonsocial = razonsocial;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

public String getDescempresa() {
	return descempresa;
}

public void setDescempresa(String descempresa) {
	this.descempresa = descempresa;
}


}
