package com.proyecto.persistencia.dao;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;

public interface PostulanteDAO {
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion;

	public Postulante insertarPostulante(Postulante postulante)
			throws DAOExcepcion;

	// Metodo que Actualiza Datos Personales del Postulante
	public Postulante actualizarPostulante(Postulante postulante)
			throws DAOExcepcion;
}
