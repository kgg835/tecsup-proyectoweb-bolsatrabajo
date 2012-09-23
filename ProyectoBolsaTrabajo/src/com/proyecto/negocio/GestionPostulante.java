package com.proyecto.negocio;

import com.proyecto.dao.PostulanteDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
//Como postulante quiero registrarme en la bolsa de trabajo
public class GestionPostulante {
	
	// como Postulantede quiero ingresar mis datos
	public Postulante insertar(String nombre, String dni)
			throws DAOExcepcion {
		PostulanteDAO dao = new PostulanteDAO();

		Postulante postulante = new Postulante();
		postulante.setNombre(nombre);
		
		postulante.setDni(dni);

		return dao.insertar(postulante);
	}
	
	public Postulante obtener(int idpostulante) throws DAOExcepcion {
		PostulanteDAO dao = new PostulanteDAO();
		return dao.obtener(idpostulante);
	}
	//Metodo pqrq eliminar un Postulante
	public void eliminar(int idPostulante) throws DAOExcepcion{
		PostulanteDAO dao=new PostulanteDAO();
		dao.eliminar(idPostulante);
	}
	
	// Como postulante quiero actualizar mi hoja de vida para las empresas.
	public void actualizarDatosPostulante() {

	}

	public void consultarAvisos() {

	}

	// Como postulante quiero poder consultar los avisos disponibles
	public void postularAvisos() {

	}

	// Como postulante deseo saber cuáles y cuantas postulaciones he realizado
	public void consultarPostulaciones() {

	}

	public void actualizardatosPostulante() {

	}

}
