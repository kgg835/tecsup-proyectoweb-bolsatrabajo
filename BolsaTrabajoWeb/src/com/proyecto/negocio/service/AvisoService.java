package com.proyecto.negocio.service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;


public interface AvisoService {
	public Aviso insertar(Aviso vo) throws DAOExcepcion ;
}
