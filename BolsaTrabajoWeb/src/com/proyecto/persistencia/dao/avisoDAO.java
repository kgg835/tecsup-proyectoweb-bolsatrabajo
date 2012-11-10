package com.proyecto.persistencia.dao;

import java.util.Collection;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;

public interface avisoDAO {
	public Aviso insertar(Aviso vo) throws DAOExcepcion;
	public Collection<Aviso> listarAvisos() throws DAOExcepcion;

}
