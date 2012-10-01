package com.proyecto.negocio;

import java.util.Collection;

import com.proyecto.dao.ConocimientoAdicionalDAO;
import com.proyecto.dao.IdiomaDAO;
import com.proyecto.dao.InformaticaDAO;
import com.proyecto.dao.PostulanteDAO;
import com.proyecto.dao.PreferenciaSalarialDAO;
import com.proyecto.dao.PresentacionDAO;
import com.proyecto.dao.ReferenciaDAO;
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.ConocimientoAdicional;
import com.proyecto.modelo.Idioma;
import com.proyecto.modelo.Informatica;
import com.proyecto.modelo.Postulante;
import com.proyecto.modelo.PreferenciaSalarial;
import com.proyecto.modelo.Presentacion;
import com.proyecto.modelo.Referencia;

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
		postulante.setApellidos(apellido);
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

	// Como postulante quiero actualizar mi hoja de vida para las empresas.

	public Idioma insertarIdioma(Idioma idioma) throws DAOExcepcion {
		IdiomaDAO dao = new IdiomaDAO();
		return dao.insertarIdioma(idioma);
	}

	public Idioma actualizarIdioma(Idioma idioma) throws DAOExcepcion {
		IdiomaDAO dao = new IdiomaDAO();
		return dao.actualizarIdioma(idioma);
	}

	// Metodo que optiene el Idioma por ID
	public Idioma obtenerIdioma(int idIdioma) throws DAOExcepcion {
		IdiomaDAO dao = new IdiomaDAO();
		return dao.obtenerIdioma(idIdioma);
	}

	// Metodo para Ingresar un conocimineto adicional
	public ConocimientoAdicional insertarConocimiento(
			ConocimientoAdicional conocimiento) throws DAOExcepcion {
		ConocimientoAdicionalDAO dao = new ConocimientoAdicionalDAO();
		return dao.insertarConocimiento(conocimiento);
	}

	// Actualiza el Conocimiento Adicional del postulante
	public ConocimientoAdicional actualizarIdioma(
			ConocimientoAdicional conocimiento) throws DAOExcepcion {
		ConocimientoAdicionalDAO dao = new ConocimientoAdicionalDAO();
		return dao.actualizarIdioma(conocimiento);
	}

	// Obtiene el Conocimiento Adicional deacuerdo al ID
	public ConocimientoAdicional obtenerConocimientoAdicional(
			int idConocimientoAd) throws DAOExcepcion {
		ConocimientoAdicionalDAO dao = new ConocimientoAdicionalDAO();
		return dao.obtenerConocimientoAdicional(idConocimientoAd);
	}

	// Metodo para Ingresar el Curso de Informatica
	public Informatica insertarInformatica(Informatica info)
			throws DAOExcepcion {
		InformaticaDAO dao = new InformaticaDAO();
		return dao.insertarInformatica(info);
	}

	// Actualiza la especialidad de Informatica del Postulante
	public Informatica actualizarInformatica(Informatica info)
			throws DAOExcepcion {
		InformaticaDAO dao = new InformaticaDAO();
		return dao.actualizarInformatica(info);
	}

	// Obtiene el conocimiento de Informatica deacuerdo al ID
	public Informatica obtenerInformatica(int idInfo) throws DAOExcepcion {
		InformaticaDAO dao = new InformaticaDAO();
		return dao.obtenerInformatica(idInfo);
	}

	// Metodo para Ingresar el Salario Preferencial
	public PreferenciaSalarial insertarSalario(PreferenciaSalarial monto)
			throws DAOExcepcion {
		PreferenciaSalarialDAO dao = new PreferenciaSalarialDAO();
		return dao.insertarSalario(monto);
	}

	// Actualiza el Idioma del postulante
	public PreferenciaSalarial actualizarSalario(PreferenciaSalarial monto)
			throws DAOExcepcion {
		PreferenciaSalarialDAO dao = new PreferenciaSalarialDAO();
		return dao.actualizarSalario(monto);
	}

	// Obtiene el Salario deacuerdo al ID
	public PreferenciaSalarial obtenerSalario(int idPreferenciaSalarial)
			throws DAOExcepcion {
		PreferenciaSalarialDAO dao = new PreferenciaSalarialDAO();
		return dao.obtenerSalario(idPreferenciaSalarial);
	}

	// Metodo para Insertar una Presentacion del Postulante
	public Presentacion insertarPresentacion(Presentacion pres)
			throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();
		return dao.insertarPresentacion(pres);
	}

	// metodo que actualiza la presentacion de un Postulante
	public Presentacion actualizar(Presentacion vo) throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();
		return dao.actualizar(vo);
	}

	// Metodo para obtener un Presentacion del Postulante
	public Presentacion obtenerPresentacion(int idPresentacion)
			throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();
		return dao.obtenerPresentacion(idPresentacion);
	}

	// Metodo que elimina una Presentacion del postulante
	public void eliminarPresentacion(int idPresentacion) throws DAOExcepcion {
		PresentacionDAO dao = new PresentacionDAO();
		dao.eliminarPresentacion(idPresentacion);
	}

	// Metodo para Ingresar una Referencia del Postulante
	public Referencia insertarReferencia(Referencia referencia)
			throws DAOExcepcion {
		ReferenciaDAO dao = new ReferenciaDAO();
		return dao.insertarReferencia(referencia);
	}

	// Metodo que actualiza la Referencia del postulante
	public Referencia actualizarReferencia(Referencia referencia)
			throws DAOExcepcion {
		ReferenciaDAO dao = new ReferenciaDAO();
		return dao.actualizarReferencia(referencia);
	}

	// Obtiene una Referncia deacuerdo al ID
	public Referencia obtenerReferencia(int idReferencia) throws DAOExcepcion {
		ReferenciaDAO dao = new ReferenciaDAO();
		return dao.obtenerReferencia(idReferencia);
	}
}
