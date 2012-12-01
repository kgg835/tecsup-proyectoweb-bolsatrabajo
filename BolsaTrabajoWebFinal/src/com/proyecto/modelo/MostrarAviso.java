package com.proyecto.modelo;

import java.util.Date;

public class MostrarAviso {
private int id_aviso;
private String Titulo;
private	Date Fec_publicacion;
private	Date Fec_caduc;
private	String Descripcion;
private	String Ruc;
private	String Razonsocial;
private	String Correo;
private	String Descempresa;
public MostrarAviso(){
	
}
public MostrarAviso(int id_aviso, String titulo, Date fec_publicacion,
		Date fec_caduc, String descripcion, String ruc, String razonsocial,
		String correo, String descempresa) {
	super();
	this.id_aviso = id_aviso;
	this.Titulo = titulo;
	this.Fec_publicacion = fec_publicacion;
	this.Fec_caduc = fec_caduc;
	this.Descripcion = descripcion;
	this.Ruc = ruc;
	this.Razonsocial = razonsocial;
	this.Correo = correo;
	this.Descempresa = descempresa;
}
public int getId_aviso() {
	return id_aviso;
}
public void setId_aviso(int id_aviso) {
	this.id_aviso = id_aviso;
}
public String getTitulo() {
	return Titulo;
}
public void setTitulo(String titulo) {
	Titulo = titulo;
}
public Date getFec_publicacion() {
	return Fec_publicacion;
}
public void setFec_publicacion(Date fec_publicacion) {
	Fec_publicacion = fec_publicacion;
}
public Date getFec_caduc() {
	return Fec_caduc;
}
public void setFec_caduc(Date fec_caduc) {
	Fec_caduc = fec_caduc;
}
public String getDescripcion() {
	return Descripcion;
}
public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}
public String getRuc() {
	return Ruc;
}
public void setRuc(String ruc) {
	Ruc = ruc;
}
public String getRazonsocial() {
	return Razonsocial;
}
public void setRazonsocial(String razonsocial) {
	Razonsocial = razonsocial;
}
public String getCorreo() {
	return Correo;
}
public void setCorreo(String correo) {
	Correo = correo;
}
public String getDescempresa() {
	return Descempresa;
}
public void setDescempresa(String descempresa) {
	Descempresa = descempresa;
}

}
