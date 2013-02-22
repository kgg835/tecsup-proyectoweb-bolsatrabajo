package com.proyecto.persistencia.dao;

import java.util.Collection;
import java.util.Date;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.MostrarAviso;

public interface avisoDAO {
	public Aviso insertar(Aviso vo) throws DAOExcepcion;
	public Collection<Aviso> listarAvisos() throws DAOExcepcion;
	public Collection<MostrarAviso> mostrar_aviso(int cod_aviso) throws DAOExcepcion;
	public Collection<Aviso> Buscar_aviso(String area,String palabra,int dias) throws DAOExcepcion;
	}
