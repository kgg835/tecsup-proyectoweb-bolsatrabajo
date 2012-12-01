package com.proyecto.negocio.service;

import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;


public interface PostulacionesService {
	public HistorialPostulaciones insertarPostulaciones(HistorialPostulaciones vo) throws DAOExcepcion;
	public Collection<HistorialPostulaciones> listarPostulaciones() throws DAOExcepcion;
}
