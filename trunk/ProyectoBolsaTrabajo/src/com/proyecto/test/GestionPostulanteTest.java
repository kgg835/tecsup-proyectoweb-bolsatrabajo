package com.proyecto.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.ConocimientoAdicional;
import com.proyecto.modelo.Idioma;
import com.proyecto.modelo.Postulante;
import com.proyecto.negocio.GestionPostulante;

public class GestionPostulanteTest {

//	@Test
	public void insertarTest() {
		GestionPostulante negocio = new GestionPostulante();
		try {
			negocio.insertar("Teresa","1000ac");
			
			Postulante nuevo=negocio.obtener(8);
			Assert.assertEquals("1000ac",nuevo.getDni());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserci�n: " + e.getMessage());
		}
	}
//	@Test
	public void listarTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {
			Collection<Postulante> listado = negocio.listar();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Fall� el listado: " + e.getMessage());

		}

	}
	
//	@Test
	public void eliminarTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {

			negocio.eliminar(2);

			Postulante nuevo = negocio.obtener(2);

			Assert.assertEquals(null, nuevo.getDni());

		} catch (DAOExcepcion e) {

			Assert.fail("Fall� la eliminici�n: " + e.getMessage());

		}

	}
	
//	@Test
	public void actualizarTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {

			negocio.actualizarPostulante("Francisco","Egas Ricaldi","francisco@gmail.com",4);

			Postulante nuevo = negocio.obtener(4);

			Assert.assertEquals("Francisco", nuevo.getNombre());

		} catch (DAOExcepcion e) {

			Assert.fail("Fall� la actualizaci�n: " + e.getMessage());

		}
	}
	//Test para Ingresar un Idioma
	@Test
	public void ingresarIdiomaTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			Idioma idioma=new Idioma();
			idioma.setNombreIdioma("Aleman");
			idioma.setNivelEscrito("Avanzado");
			idioma.setNivelOral("Intermedio");
			
			negocio.insertarIdioma(idioma);
			
			Idioma nuevo=negocio.obtenerIdioma(3);
			Assert.assertEquals("Aleman",nuevo.getNombreIdioma());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� la el ingreso: " + e.getMessage());

		}
	}
	
	//Test para ingresar un Conocimiento Adicional
	@Test
	public void ingresarConocimientoAdicionalTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			ConocimientoAdicional conocimiento=new ConocimientoAdicional();
			conocimiento.setNombreConocimiento("PHP");
			conocimiento.setDescrpcionConocimiento("Programador en lenguaje PHP Web");
			negocio.insertarConocimiento(conocimiento);
			
			ConocimientoAdicional nuevo=negocio.obtenerConocimientoAdicional(3);
			
			Assert.assertEquals("PHP",nuevo.getNombreConocimiento());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fall� el Ingreso de Conocimiento: " + e.getMessage());
		}
	}

}
