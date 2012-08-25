package com.proyecto.modelo;

import java.util.Collection;
import java.util.Date;

public class Aviso {
	String cod_aviso;
	String titulo;
	Date fec_publicacion;
	Date fec_caduc;
	String cod_ofertante;
	String codarea;
	//Aviso tiene de 0 a muchos postulantes
	private Collection<Postulante> listaPostulantes;

	public Aviso() {
	}

	public Aviso(String cod_aviso, String titulo, Date fec_publicacion,
			Date fec_caduc, String cod_ofertante, String codarea) {
		super();
		this.cod_aviso = cod_aviso;
		this.titulo = titulo;
		this.fec_publicacion = fec_publicacion;
		this.fec_caduc = fec_caduc;
		this.cod_ofertante = cod_ofertante;
		this.codarea = codarea;
	}

	public String getCod_aviso() {
		return cod_aviso;
	}

	public void setCod_aviso(String cod_aviso) {
		this.cod_aviso = cod_aviso;
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

	public String getCod_ofertante() {
		return cod_ofertante;
	}

	public void setCod_ofertante(String cod_ofertante) {
		this.cod_ofertante = cod_ofertante;
	}

	public String getCodarea() {
		return codarea;
	}

	public void setCodarea(String codarea) {
		this.codarea = codarea;
	}

	public void setListaPostulantes(Collection<Postulante> listaPostulantes) {
		this.listaPostulantes = listaPostulantes;
	}

	public Collection<Postulante> getListaPostulantes() {
		return listaPostulantes;
	}

}
