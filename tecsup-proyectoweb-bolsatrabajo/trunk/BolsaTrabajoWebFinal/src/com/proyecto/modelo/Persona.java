package com.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPERSONA;

	private String apellidosPersona;

	private String direccion;

	private String dni;

	private String email;

	private String estadoCivil;

	private String fechaNacimiento;

	private String nombrePersona;

	private String numeroCelular;

	private String pais;

	private String sexo;

	private String telefonoFijo;

	@Column(name="tipo_persona")
	private String tipoPersona;

	//bi-directional many-to-one association to ConocimientoAdicional
	@OneToMany(mappedBy="persona")
	private Set<ConocimientoAdicional> conocimientoAdicionals;

	//bi-directional many-to-one association to Estudio
	@OneToMany(mappedBy="persona")
	private Set<Estudio> estudios;

	//bi-directional many-to-one association to ExperienciaLaboral
	@OneToMany(mappedBy="persona")
	private Set<ExperienciaLaboral> experienciaLaborals;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	//bi-directional many-to-many association to Aviso
    @ManyToMany
	@JoinTable(
		name="persona_aviso"
		, joinColumns={
			@JoinColumn(name="idPERSONA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idAVISO")
			}
		)
	private Set<Aviso> avisos;

	//bi-directional many-to-many association to Idioma
    @ManyToMany
	@JoinTable(
		name="persona_idioma"
		, joinColumns={
			@JoinColumn(name="idPERSONA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idIDIOMA")
			}
		)
	private Set<Idioma> idiomas;

	//bi-directional many-to-one association to PreferenciaSalarial
	@OneToMany(mappedBy="persona")
	private Set<PreferenciaSalarial> preferenciaSalarials;

	//bi-directional many-to-one association to Presentacion
	@OneToMany(mappedBy="persona")
	private Set<Presentacion> presentacions;

	//bi-directional many-to-one association to Puesto
	@OneToMany(mappedBy="persona")
	private Set<Puesto> puestos;

	//bi-directional many-to-one association to Referencia
	@OneToMany(mappedBy="persona")
	private Set<Referencia> referencias;

	//bi-directional many-to-one association to SeleccionPostulante
	@OneToMany(mappedBy="persona")
	private Set<SeleccionPostulante> seleccionPostulantes;

    public Persona() {
    }

	public int getIdPERSONA() {
		return this.idPERSONA;
	}

	public void setIdPERSONA(int idPERSONA) {
		this.idPERSONA = idPERSONA;
	}

	public String getApellidosPersona() {
		return this.apellidosPersona;
	}

	public void setApellidosPersona(String apellidosPersona) {
		this.apellidosPersona = apellidosPersona;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombrePersona() {
		return this.nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getNumeroCelular() {
		return this.numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefonoFijo() {
		return this.telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Set<ConocimientoAdicional> getConocimientoAdicionals() {
		return this.conocimientoAdicionals;
	}

	public void setConocimientoAdicionals(Set<ConocimientoAdicional> conocimientoAdicionals) {
		this.conocimientoAdicionals = conocimientoAdicionals;
	}
	
	public Set<Estudio> getEstudios() {
		return this.estudios;
	}

	public void setEstudios(Set<Estudio> estudios) {
		this.estudios = estudios;
	}
	
	public Set<ExperienciaLaboral> getExperienciaLaborals() {
		return this.experienciaLaborals;
	}

	public void setExperienciaLaborals(Set<ExperienciaLaboral> experienciaLaborals) {
		this.experienciaLaborals = experienciaLaborals;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<Aviso> getAvisos() {
		return this.avisos;
	}

	public void setAvisos(Set<Aviso> avisos) {
		this.avisos = avisos;
	}
	
	public Set<Idioma> getIdiomas() {
		return this.idiomas;
	}

	public void setIdiomas(Set<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
	
	public Set<PreferenciaSalarial> getPreferenciaSalarials() {
		return this.preferenciaSalarials;
	}

	public void setPreferenciaSalarials(Set<PreferenciaSalarial> preferenciaSalarials) {
		this.preferenciaSalarials = preferenciaSalarials;
	}
	
	public Set<Presentacion> getPresentacions() {
		return this.presentacions;
	}

	public void setPresentacions(Set<Presentacion> presentacions) {
		this.presentacions = presentacions;
	}
	
	public Set<Puesto> getPuestos() {
		return this.puestos;
	}

	public void setPuestos(Set<Puesto> puestos) {
		this.puestos = puestos;
	}
	
	public Set<Referencia> getReferencias() {
		return this.referencias;
	}

	public void setReferencias(Set<Referencia> referencias) {
		this.referencias = referencias;
	}
	
	public Set<SeleccionPostulante> getSeleccionPostulantes() {
		return this.seleccionPostulantes;
	}

	public void setSeleccionPostulantes(Set<SeleccionPostulante> seleccionPostulantes) {
		this.seleccionPostulantes = seleccionPostulantes;
	}
	
}