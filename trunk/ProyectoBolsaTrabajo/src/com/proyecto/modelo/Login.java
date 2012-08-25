package com.proyecto.modelo;

public class Login {
	
	private String usuario;
	private String password;
	
	//Un login pertenece a un Postulante
	private Postulante loginPostulante;
	
	public Login() {
	}

	public Login(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
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

	public void setLoginPostulante(Postulante loginPostulante) {
		this.loginPostulante = loginPostulante;
	}

	public Postulante getLoginPostulante() {
		return loginPostulante;
	}

}
