package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ofertante database table.
 * 
 */
@Entity
public class Ofertante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOFERTANTE;

	private String correo;

	private String descEmpresa;

	private String razonSocial;

	private String ruc;

	private String usuarioOf;

	//bi-directional many-to-one association to Aviso
	@OneToMany(mappedBy="ofertante")
	private Set<Aviso> avisos;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

    public Ofertante() {
    }

	public int getIdOFERTANTE() {
		return this.idOFERTANTE;
	}

	public void setIdOFERTANTE(int idOFERTANTE) {
		this.idOFERTANTE = idOFERTANTE;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescEmpresa() {
		return this.descEmpresa;
	}

	public void setDescEmpresa(String descEmpresa) {
		this.descEmpresa = descEmpresa;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getUsuarioOf() {
		return this.usuarioOf;
	}

	public void setUsuarioOf(String usuarioOf) {
		this.usuarioOf = usuarioOf;
	}

	public Set<Aviso> getAvisos() {
		return this.avisos;
	}

	public void setAvisos(Set<Aviso> avisos) {
		this.avisos = avisos;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}