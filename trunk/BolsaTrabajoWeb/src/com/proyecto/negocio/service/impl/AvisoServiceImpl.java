package com.proyecto.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.Postulante;
import com.proyecto.negocio.service.AvisoService;
import com.proyecto.negocio.service.PostulanteService;
import com.proyecto.persistencia.dao.PostulanteDAO;
import com.proyecto.persistencia.dao.avisoDAO;

@Service
public class AvisoServiceImpl implements AvisoService{
	
	@Autowired
	private avisoDAO AvisoDAO;
	

		@Override
		public Aviso insertar(Aviso vo) throws DAOExcepcion {
			// TODO Auto-generated method stub
			return AvisoDAO.insertar(vo);
		}
		
}


