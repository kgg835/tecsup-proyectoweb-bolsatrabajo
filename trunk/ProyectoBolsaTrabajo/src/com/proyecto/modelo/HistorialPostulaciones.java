package com.proyecto.modelo;
import java.util.Collection;

public class HistorialPostulaciones {
	private String idpostulacion;
	private String descempresa;
	private String tituloAviso;
	private String fechapublicacion;
	private String fechpostulacion;
	private String Estado;
	
	
	Collection<HistorialPostulaciones> historialPostulaciones;
	
	




	public HistorialPostulaciones(String idpostulacion, String descempresa,
			String tituloAviso, String fechapublicacion,
			String fechpostulacion, String estado,
			Collection<HistorialPostulaciones> historialPostulaciones) {
		super();
		this.idpostulacion = idpostulacion;
		this.descempresa = descempresa;
		this.tituloAviso = tituloAviso;
		this.fechapublicacion = fechapublicacion;
		this.fechpostulacion = fechpostulacion;
		Estado = estado;
		this.historialPostulaciones = historialPostulaciones;
	}




	public String getIdpostulacion() {
		return idpostulacion;
	}




	public void setIdpostulacion(String idpostulacion) {
		this.idpostulacion = idpostulacion;
	}




	public HistorialPostulaciones() {
		
		// TODO Auto-generated constructor stub
	}




	public HistorialPostulaciones(String descempresa, String tituloAviso,
			String fechapublicacion, String fechpostulacion, String estado) {
		super();
		this.descempresa = descempresa;
		this.tituloAviso = tituloAviso;
		this.fechapublicacion = fechapublicacion;
		this.fechpostulacion = fechpostulacion;
		Estado = estado;
	}




	public String getDescempresa() {
		return descempresa;
	}




	public void setDescempresa(String descempresa) {
		this.descempresa = descempresa;
	}




	public String getTituloAviso() {
		return tituloAviso;
	}




	public void setTituloAviso(String tituloAviso) {
		this.tituloAviso = tituloAviso;
	}




	public String getFechapublicacion() {
		return fechapublicacion;
	}




	public void setFechapublicacion(String fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}




	public String getFechpostulacion() {
		return fechpostulacion;
	}




	public void setFechpostulacion(String fechpostulacion) {
		this.fechpostulacion = fechpostulacion;
	}




	public String getEstado() {
		return Estado;
	}




	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public Collection<HistorialPostulaciones> getHistorialPostulaciones() {
		return historialPostulaciones;
	}




	public void setHistorialPostulaciones(
			Collection<HistorialPostulaciones> historialPostulaciones) {
		this.historialPostulaciones = historialPostulaciones;
	}


}
