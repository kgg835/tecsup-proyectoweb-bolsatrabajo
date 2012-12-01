package com.proyecto.negocio.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;

import com.proyecto.negocio.service.PostulacionesService;

import com.proyecto.persistencia.dao.PostulacionesDAO;
;

@Service
public class PostulacionesServiceImpl implements PostulacionesService {
	
	@Autowired
	private PostulacionesDAO postulacionesDAO;
	
	
	@Override
public HistorialPostulaciones insertarPostulaciones(HistorialPostulaciones vo) throws DAOExcepcion{
		return postulacionesDAO.insertarPostulacion(vo);
		
		}
	
	public Collection<HistorialPostulaciones> listarPostulaciones() throws DAOExcepcion{
		return postulacionesDAO.listarPostulaciones();
	}

}
