package com.proyecto.negocio.service;

import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.HistorialPostulaciones;


public interface AvisoService {
	public Aviso insertar(Aviso vo) throws DAOExcepcion ;
	public Collection<Aviso> listarAvisos() throws DAOExcepcion;

}
