package com.proyecto.persistencia.dao;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;

public interface PostulanteDAO {
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion;
}
