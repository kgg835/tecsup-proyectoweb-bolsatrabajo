package com.proyecto.modelo;

import java.util.Collection;
import java.util.Date;

public class Aviso {
	int idOfertante;
	int id_puesto;
	int id_area;
	String titulo;
	String descripcion;
	Date fec_publicacion;
	Date fec_caduc;
	
	//Aviso tiene de 0 a muchos postulantes
	private Collection<Postulante> listaPostulantes;
	//Un Aviso le Pertenece a un Ofertante
	private Ofertante empresa;
	//Un Aviso pertenece a un Puesto
	private Puesto puesto;
	//Un Aviso tiene varias selecciones
	private Collection<Seleccion> listaSeleccion;
	
	public Aviso() {
	}

	public Aviso(int idOfertante,int id_puesto,int id_area, String titulo,String descripcion, Date fec_publicacion,
			Date fec_caduc) {
		super();
	this.idOfertante=idOfertante;
	this.id_puesto=id_puesto;
	this.id_area=id_area;
		this.titulo = titulo;
		this.descripcion=descripcion;
		this.fec_publicacion = fec_publicacion;
		this.fec_caduc = fec_caduc;
	
	}




	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	public int getIdOfertante() {
		return idOfertante;
	}

	public void setIdOfertante(int idOfertante) {
		this.idOfertante = idOfertante;
	}

	public int getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(int id_puesto) {
		this.id_puesto = id_puesto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFec_publicacion() {
		return fec_publicacion;
	}

	public void setFec_publicacion(Date fec_publicacion) {
		this.fec_publicacion = fec_publicacion;
	}

	public Date getFec_caduc() {
		return fec_caduc;
	}

	public void setFec_caduc(Date fec_caduc) {
		this.fec_caduc = fec_caduc;
	}



	public void setListaPostulantes(Collection<Postulante> listaPostulantes) {
		this.listaPostulantes = listaPostulantes;
	}

	public Collection<Postulante> getListaPostulantes() {
		return listaPostulantes;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setEmpresa(Ofertante empresa) {
		this.empresa = empresa;
	}

	public Ofertante getEmpresa() {
		return empresa;
	}

	public void setListaSeleccion(Collection<Seleccion> listaSeleccion) {
		this.listaSeleccion = listaSeleccion;
	}

	public Collection<Seleccion> getListaSeleccion() {
		return listaSeleccion;
	}

}
