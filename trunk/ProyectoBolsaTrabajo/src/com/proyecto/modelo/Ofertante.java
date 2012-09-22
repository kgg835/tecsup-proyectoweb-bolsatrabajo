package com.proyecto.modelo;

import java.util.Collection;

public class Ofertante {

	private String ruc;
	private String razonsocial;
	private String correo;
	private String contraseña;
	private String descempresa;
	private String usuario;
	private String password;
	//Un Ofertante puede publicar varios avisos
	private Collection<Aviso> listaAvisos;
	
	
	public Ofertante() {
	}

	public Ofertante(String ruc, String razonsocial,
			String correo, String contraseña, String descempresa,String usua,String pass) {
		super();
		this.ruc = ruc;
		this.razonsocial = razonsocial;
		this.correo = correo;
		this.contraseña = contraseña;
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
