package com.proyecto.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.ConocimientoAdicional;
import com.proyecto.modelo.Idioma;
import com.proyecto.modelo.Informatica;
import com.proyecto.modelo.Postulante;
import com.proyecto.modelo.PreferenciaSalarial;
import com.proyecto.modelo.Presentacion;
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
			Assert.fail("Fallo la inserción: " + e.getMessage());
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

			Assert.fail("Falló el listado: " + e.getMessage());

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

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}
	
//	@Test
	public void actualizarTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {

			negocio.actualizarPostulante("Francisco","Egas Ricaldi","francisco@gmail.com",4);

			Postulante nuevo = negocio.obtener(1);

			Assert.assertEquals("Francisco", nuevo.getNombre());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la actualización: " + e.getMessage());

		}
	}
	//Test para Ingresar un Idioma
//	@Test
	public void ingresarIdiomaTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			Idioma idioma=new Idioma();
			idioma.setNombreIdioma("Ingles");
			idioma.setNivelEscrito("Avanzado");
			idioma.setNivelOral("intermedio");
			
			negocio.insertarIdioma(idioma);
			
			Idioma nuevo=negocio.obtenerIdioma(2);
			Assert.assertEquals("Ingles",nuevo.getNombreIdioma());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló la el ingreso: " + e.getMessage());

		}
	}
	
	//Test para ingresar un Conocimiento Adicional
//	@Test
	public void ingresarConocimientoAdicionalTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			ConocimientoAdicional conocimiento=new ConocimientoAdicional();
			conocimiento.setNombreConocimiento("PHP");
			conocimiento.setDescrpcionConocimiento("Programador en lenguaje PHP Web");
			negocio.insertarConocimiento(conocimiento);
			
			ConocimientoAdicional nuevo=negocio.obtenerConocimientoAdicional(1);
			
			Assert.assertEquals("PHP",nuevo.getNombreConocimiento());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso de Conocimiento: " + e.getMessage());
		}
	}
	
	//Test para Ingresar Informatica
//	@Test
	public void ingresarInformaticaTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			Informatica info=new Informatica();
			info.setTipoInformatica("Windows 8");
			info.setNivelInformatica("Administardor de windows");
			
			negocio.insertarInformatica(info);
			
			Informatica nuevo=negocio.obtenerInformatica(1);
			
			Assert.assertEquals("Windows 8",nuevo.getTipoInformatica());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso de Informatica: " + e.getMessage());
		}
	}
	
	//Test para ingresar una Preferiencia Salarial
	//@SuppressWarnings("deprecation")
	
//	@Test
	public void ingresarPreferenciaSalarialTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			PreferenciaSalarial monto=new PreferenciaSalarial();
			monto.setMontoSoles(2800);
			monto.setMontoDolares(0);
			
			negocio.insertarSalario(monto);
			
			PreferenciaSalarial nuevo=negocio.obtenerSalario(2);
			
			Assert.assertEquals(Double.doubleToLongBits(2800),Double.doubleToLongBits(nuevo.getMontoSoles()));
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso del Salario: " + e.getMessage());
		}
	}
	//Test que prueba el ingreso de una Presentacion
	@Test
	public void ingresarPresentacionTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			Presentacion prese=new Presentacion();
			prese.setDescripcionPres("Programador Java");
			
			negocio.insertarPresentacion(prese);
			
			Presentacion nuevo=negocio.obtenerPresentacion(3);
			
			Assert.assertEquals("Programador Java",nuevo.getDescripcionPres());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso de la Presentacion: " + e.getMessage());
		}
	}

}
