package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idROL;

	private String tipoRol;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private Set<Usuario> usuarios;

    public Rol() {
    }

	public int getIdROL() {
		return this.idROL;
	}

	public void setIdROL(int idROL) {
		this.idROL = idROL;
	}

	public String getTipoRol() {
		return this.tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}