package com.proyecto.modelo;

import java.util.Collection;

public class Ofertante {
private int idofertante;
	private String ruc;
	private String razonsocial;
	private String correo;
	private String descempresa;
	private String usuario;
	private String password;
	//Un Ofertante puede publicar varios avisos
	private Collection<Aviso> listaAvisos;
	
	
	public Ofertante() {
	}

	public int getidofertante() {
		return idofertante;
	}

	public void setidofertante(int idofertante) {
		this.idofertante = idofertante;
	}

	public Ofertante(int idofertante,String ruc, String razonsocial,
			String correo, String descempresa,String usua,String pass) {
		super();
		this.idofertante=idofertante;
		this.ruc = ruc;
		this.razonsocial = razonsocial;
		this.correo = correo;
	
		this.descempresa = descempresa;
		this.usuario=usua;
		this.password=pass;
		
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




	public String getDescempresa() {
		return descempresa;
	}

	public void setDescempresa(String descempresa) {
		this.descempresa = descempresa;
	}

	public void setListaAvisos(Collection<Aviso> listaAvisos) {
		this.listaAvisos = listaAvisos;
	}

	public Collection<Aviso> getListaAvisos() {
		return listaAvisos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
