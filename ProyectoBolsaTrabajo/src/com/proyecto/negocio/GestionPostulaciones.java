package com.proyecto.negocio;

import java.util.Collection;

import com.proyecto.dao.HistorialPostulacionesDAO;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;

public class GestionPostulaciones {

	public Collection<HistorialPostulaciones> listarpostulaciones()
			throws DAOExcepcion {
		HistorialPostulacionesDAO dao = new HistorialPostulacionesDAO();
		return dao.listarpostulaciones();
	}
}
