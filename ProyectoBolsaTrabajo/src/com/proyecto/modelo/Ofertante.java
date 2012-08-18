package com.proyecto.modelo;

public class Ofertante {
private String codofertante;
private String ruc;
private String razonsocial;
private String correo;
private String contrase�a;
private String descempresa;

public Ofertante(){}

public Ofertante(String codofertante, String ruc, String razonsocial,
		String correo, String contrase�a, String descempresa) {
	super();
	this.codofertante = codofertante;
	this.ruc = ruc;
	this.razonsocial = razonsocial;
	this.correo = correo;
	this.contrase�a = contrase�a;
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

public String getContrase�a() {
	return contrase�a;
}

public void setContrase�a(String contrase�a) {
	this.contrase�a = contrase�a;
}

public String getDescempresa() {
	return descempresa;
}

public void setDescempresa(String descempresa) {
	this.descempresa = descempresa;
}


}
