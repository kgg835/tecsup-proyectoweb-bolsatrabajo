package com.proyecto.persistencia.dao;

import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;

public interface PostulacionesDAO {

	public HistorialPostulaciones insertarPostulacion(HistorialPostulaciones vo) throws DAOExcepcion;
	public Collection<HistorialPostulaciones> listarPostulaciones() throws DAOExcepcion;
}
