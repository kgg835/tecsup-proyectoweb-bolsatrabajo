package com.proyecto.negocio.service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;

public interface PostulanteService {
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion;
	public Postulante insertarPostulante(Postulante postulante)throws DAOExcepcion;
}
