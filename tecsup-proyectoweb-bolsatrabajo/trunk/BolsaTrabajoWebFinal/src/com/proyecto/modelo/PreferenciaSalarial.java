package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the preferencia_salarial database table.
 * 
 */
@Entity
@Table(name="preferencia_salarial")
public class PreferenciaSalarial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPREFERENCIA_SALARIAL;

	private BigDecimal montoDolares;

	private BigDecimal montoSoles;

	//bi-directional many-to-one association to Persona
    @ManyToOne
	@JoinColumn(name="idPERSONA")
	private Persona persona;

    public PreferenciaSalarial() {
    }

	public int getIdPREFERENCIA_SALARIAL() {
		return this.idPREFERENCIA_SALARIAL;
	}

	public void setIdPREFERENCIA_SALARIAL(int idPREFERENCIA_SALARIAL) {
		this.idPREFERENCIA_SALARIAL = idPREFERENCIA_SALARIAL;
	}

	public BigDecimal getMontoDolares() {
		return this.montoDolares;
	}

	public void setMontoDolares(BigDecimal montoDolares) {
		this.montoDolares = montoDolares;
	}

	public BigDecimal getMontoSoles() {
		return this.montoSoles;
	}

	public void setMontoSoles(BigDecimal montoSoles) {
		this.montoSoles = montoSoles;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}