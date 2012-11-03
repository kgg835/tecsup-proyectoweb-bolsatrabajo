package com.proyecto.persistencia.dao;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.Usuario;

public interface avisoDAO {
	public Aviso insertar(Aviso vo) throws DAOExcepcion;
}
