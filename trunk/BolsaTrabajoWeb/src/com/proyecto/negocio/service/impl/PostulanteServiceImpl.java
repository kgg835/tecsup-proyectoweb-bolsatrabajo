package com.proyecto.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.negocio.service.PostulanteService;
import com.proyecto.persistencia.dao.PostulanteDAO;

@Service
public class PostulanteServiceImpl implements PostulanteService{
	
	@Autowired
	private PostulanteDAO postulanteDAO;
	
	@Override
	public Postulante obtenerPostulante(int idPostulante) throws DAOExcepcion {
		return postulanteDAO.obtenerPostulante(idPostulante);
	}

}
