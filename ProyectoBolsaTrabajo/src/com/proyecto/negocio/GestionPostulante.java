package com.proyecto.negocio;

import java.util.Collection;

import com.proyecto.dao.PostulanteDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;

//Como postulante quiero registrarme en la bolsa de trabajo
public class GestionPostulante {

	// como Postulantede quiero ingresar mis datos
	public Postulante insertar(String nombre, String dni) throws DAOExcepcion {
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

	// Metodo para eliminar un Postulante
	public void eliminar(int idPostulante) throws DAOExcepcion {
		PostulanteDAO dao = new PostulanteDAO();
		dao.eliminar(idPostulante);
	}

	// Como postulante quiero actualizar mi hoja de vida para las empresas.
	public Postulante actualizarPostulante(String nombre, String apellido,
			String mail, int id) throws DAOExcepcion {
		PostulanteDAO dao = new PostulanteDAO();
		Postulante postulante = new Postulante();
		postulante.setNombre(nombre);
		postulante.setApPaterno(apellido);
		postulante.setEmail(mail);
		postulante.setIdPostulante(id);
		return dao.actualizarPostulante(postulante);
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

	// Metodo para listar todos los postulantes
	public Collection<Postulante> listar() throws DAOExcepcion {
		PostulanteDAO dao = new PostulanteDAO();
		return dao.listar();
	}

	// Busca al Postulante pos DNI
	public Collection<Postulante> buscarPostulante(String nrodni)
			throws DAOExcepcion {
		PostulanteDAO dao = new PostulanteDAO();
		return dao.buscarPostulante(nrodni);
	}

}
