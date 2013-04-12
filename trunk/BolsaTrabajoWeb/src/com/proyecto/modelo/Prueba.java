/**
 * 
 */
package com.proyecto.modelo;

import java.io.Serializable;

/**
 * @author Anderson
 *
 */
public class Prueba implements Serializable{
	private String usuario;
	private String clave;
	
	public Prueba(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}
	public Prueba() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
