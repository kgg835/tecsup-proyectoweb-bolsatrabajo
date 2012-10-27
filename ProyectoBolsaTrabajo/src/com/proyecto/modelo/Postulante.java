package com.proyecto.modelo;

import java.io.Serializable;
import java.util.Collection;
import com.proyecto.modelo.Presentacion;
import com.proyecto.modelo.PreferenciaSalarial;

public class Postulante extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idPostulante;
	private String codseleccion;
	private String email;
	private String sexo;
	private String fechaNacimiento;
	private String direccion;
	private String estadoCivil;
	private String telefonoFijo;
	private String telefonoCel;
	private String passwordPE;
	private String codPostulante;
	private String paisPostulante;
	private int idPresentacion;
	private String provinciaPostulante;
	private String ciudadPostulante;
	private int idPreferencia_Salarial;
	private int idUsuario;


	// Un postulante tiene un registro de login
//	private Login loginPostulante;
	private Collection<HistorialPostulaciones> historialPostulacion;
	// Un postulante puede consultar de 0 a muchos Avisos
	private Collection<Aviso> listaAvisos;
	private Presentacion presentacion;
	private PreferenciaSalarial preferenciaSalarial;
	
	//Un Postulante tiene de 1 a mas Referencias
	private Collection<Referencia> listaReferencias;

	// Un postulante tiene de 0 a muchas postulaciones
	
	// Un Postulante tiene de 0 a muchas Experiencias Laborales
	private Collection<ExperienciaLaboral> listaExperiencialaboral;
	
	//Un Estudiante tiene de 1 a muchos Estudios Realizados
	private Collection<Estudio> listaEstudios;
	
	// Un postulante es una Persona
	public Postulante() {
		super();
	}

	public Postulante(String codseleccion) {
		super();
		this.codseleccion = codseleccion;
	}

	public String getCodseleccion() {
		return codseleccion;
	}

	public void setCodseleccion(String codseleccion) {
		this.codseleccion = codseleccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	
//	public void setRegistroPostulante(RegistroPostulante registroPostulante) {
//		this.registroPostulante = registroPostulante;
//	}
//
//	public RegistroPostulante getRegistroPostulante() {
//		return registroPostulante;
//	}

//	public void setLoginPostulante(Login loginPostulante) {
//		this.loginPostulante = loginPostulante;
//	}
//
//	public Login getLoginPostulante() {
//		return loginPostulante;
//	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getTelefonoCel() {
		return telefonoCel;
	}

	public void setTelefonoCel(String telefonoCel) {
		this.telefonoCel = telefonoCel;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public void setListaAvisos(Collection<Aviso> listaAvisos) {
		this.listaAvisos = listaAvisos;
	}

	public Collection<Aviso> getListaAvisos() {
		return listaAvisos;
	}

	public String getPasswordPE() {
		return passwordPE;
	}

	public void setPasswordPE(String passwordPE) {
		this.passwordPE = passwordPE;
	}

	public void setPreferenciaSalarial(PreferenciaSalarial preferenciaSalarial) {
		this.preferenciaSalarial = preferenciaSalarial;
	}

	public PreferenciaSalarial getPreferenciaSalarial() {
		return preferenciaSalarial;
	}

	public void setListaReferencias(Collection<Referencia> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

	public Collection<Referencia> getListaReferencias() {
		return listaReferencias;
	}

	public void setListaExperiencialaboral(Collection<ExperienciaLaboral> listaExperiencialaboral) {
		this.listaExperiencialaboral = listaExperiencialaboral;
	}

	public Collection<ExperienciaLaboral> getListaExperiencialaboral() {
		return listaExperiencialaboral;
	}

	public void setListaEstudios(Collection<Estudio> listaEstudios) {
		this.listaEstudios = listaEstudios;
	}

	public Collection<Estudio> getListaEstudios() {
		return listaEstudios;
	}

	public void setIdPresentacion(int idPresentacion) {
		this.idPresentacion = idPresentacion;
	}

	public int getIdPresentacion() {
		return idPresentacion;
	}

	public void setIdPreferencia_Salarial(int idPreferencia_Salarial) {
		this.idPreferencia_Salarial = idPreferencia_Salarial;
	}

	public int getIdPreferencia_Salarial() {
		return idPreferencia_Salarial;
	}

	public void setCiudadPostulante(String ciudadPostulante) {
		this.ciudadPostulante = ciudadPostulante;
	}

	public String getCiudadPostulante() {
		return ciudadPostulante;
	}

	public void setProvinciaPostulante(String provinciaPostulante) {
		this.provinciaPostulante = provinciaPostulante;
	}

	public String getProvinciaPostulante() {
		return provinciaPostulante;
	}

	public void setPaisPostulante(String paisPostulante) {
		this.paisPostulante = paisPostulante;
	}

	public String getPaisPostulante() {
		return paisPostulante;
	}

	public void setCodPostulante(String codPostulante) {
		this.codPostulante = codPostulante;
	}

	public String getCodPostulante() {
		return codPostulante;
	}

	
	

	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Collection<HistorialPostulaciones> getHistorialPostulacion() {
		return historialPostulacion;
	}

	public void setHistorialPostulacion(Collection<HistorialPostulaciones> historialPostulacion) {
		this.historialPostulacion = historialPostulacion;
	}



//	public void setListaregistroPostulacion(
//			Collection<RegistroPostulacion> listaregistroPostulacion) {
//		this.listaregistroPostulacion = listaregistroPostulacion;
//	}
//
//	public Collection<RegistroPostulacion> getListaregistroPostulacion() {
//		return listaregistroPostulacion;
//	}

}
