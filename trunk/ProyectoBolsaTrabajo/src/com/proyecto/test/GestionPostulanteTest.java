package com.proyecto.test;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.ConocimientoAdicional;
import com.proyecto.modelo.Estudio;
import com.proyecto.modelo.ExperienciaLaboral;
import com.proyecto.modelo.Idioma;
import com.proyecto.modelo.Informatica;
import com.proyecto.modelo.Postulante;
import com.proyecto.modelo.PreferenciaSalarial;
import com.proyecto.modelo.Presentacion;
import com.proyecto.modelo.Referencia;
import com.proyecto.negocio.GestionPostulante;

public class GestionPostulanteTest {

	@Test
	public void insertarPostulanteTest() {
		GestionPostulante negocio = new GestionPostulante();
		try {
			Postulante postulante=new Postulante();
			postulante.setTipoPersona("Postulante");
			postulante.setNombre("Camila larisa");
			postulante.setApellidos("Roman Egas");
			postulante.setDni("56897845");
			postulante.setCodPostulante("300");
			postulante.setPasswordPE("4444444");
			postulante.setEmail("camila@gmail.com");
			postulante.setPaisPostulante("Peru");
			postulante.setProvinciaPostulante("Lima");
			postulante.setCiudadPostulante("Lima");
			postulante.setDireccion("Calle teresa G. de Fannyg 317");
			postulante.setTelefonoFijo("3273208");
			postulante.setTelefonoCel("785785785");
			postulante.setFechaNacimiento("15/04/2012");
			postulante.setSexo("F");
			postulante.setEstadoCivil("Soltera");
			postulante.setIdPresentacion(5);
			postulante.setIdPreferencia_Salarial(5);
			
			negocio.insertarPostulante(postulante);
			
			Postulante nuevo=negocio.obtenerPostulante(5);
			Assert.assertEquals("Camila larisa",nuevo.getNombre());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
//	@Test
	public void listarPostulanteTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {
			Collection<Postulante> listado = negocio.listarPostulante();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}
	
//	@Test
	public void eliminarPostulanteTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {

			negocio.eliminarPostulante(2);

			Postulante nuevo = negocio.obtenerPostulante(2);

			Assert.assertEquals(null, nuevo.getDni());

		} catch (DAOExcepcion e) {

			Assert.fail("Falló la eliminición: " + e.getMessage());

		}

	}
	
//	@Test
	public void actualizarPostulanteTest() {

		GestionPostulante negocio = new GestionPostulante();

		try {

			//negocio.actualizarPostulante("Francisco","Egas Ricaldi","francisco@gmail.com",4);

			Postulante nuevo = negocio.obtenerPostulante(1);

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
//	@Test
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
	
	//Test que prueba el Ingreso de una Referencia
//	@Test
	public void insertarReferenciaTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			Referencia referencia=new Referencia();
			referencia.setNombreReferencia("Francisco");
			referencia.setCodPostulante(3);
			referencia.setApellidoReferencia("Egas Ricaldi");
			referencia.setEmail("franciscopendeivis@yahoo.com");
			referencia.setTelefonoReferencia("3273208");
			referencia.setRelacion("Director");
			referencia.setPuestoEmpresa("profesor");
			referencia.setExperienciaRelacionada("profesor de Secundaria");
			
			negocio.insertarReferencia(referencia);
			
			Referencia nuevo=negocio.obtenerReferencia(5);
			
			Assert.assertEquals("Francisco",nuevo.getNombreReferencia());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso de la Referencia: " + e.getMessage());
		}
	}
	
	//Test que prueba el ingreso de una Experiacia Laboral del postulante
//	@Test
	public void insertarExperienciaLaboralTest(){
		GestionPostulante negocio=new GestionPostulante();
		
		try {
			ExperienciaLaboral experiencia=new ExperienciaLaboral();
			experiencia.setTituloPuesto("Consultor Java");
			experiencia.setEmpresa("Teamsoft");
			experiencia.setPais("Peru");
			experiencia.setFechaInicio("01/05/2012");
			experiencia.setFechaFinal("15/07/2012");
			experiencia.setArea("Arquitectura y Sistemas TI");
			experiencia.setSubArea("Desarrollo");
			experiencia.setDescripcionResponsabilidad("apollo en desarrollo a los developers");
			experiencia.setNumPersonasCargo(0);
			experiencia.setIdPostulante(7);
			
			negocio.insertarExperienciaLaboral(experiencia);
			
			ExperienciaLaboral nuevo=negocio.obtenerExperienciaLaboral(5);
			
			Assert.assertEquals("Consultor Java",nuevo.getTituloPuesto());
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso de la Experiencia Laboral: " + e.getMessage());
		}
	}
	
	//Test que prueba el ingreso de un Estudio realizado por el Postulante
//	@Test
	public void ingresarEstudioTest(){
		GestionPostulante negocio=new GestionPostulante();
		try {
			Estudio estudio=new Estudio();
			estudio.setTituloEstudio("Developer Certification Java");
			estudio.setFechaInicio("04/05/2012");
			estudio.setFechaFinal("30/11/2012");
			estudio.setDescripcionInstutucion("CIBERTEC");
			estudio.setPais("PERU");
			estudio.setNivelEstudio("Superior");
			estudio.setEstado("Activo");
			estudio.setAreaEstudio("Sistemas de Informacion");
			estudio.setPromedio(13);
			estudio.setMateriasAprovadas(50);
			estudio.setCantidadMaterias(50);
			estudio.setIdPersona(3);
			
			negocio.insertarEstudio(estudio);
			
			Estudio nuevo=negocio.obtenerEstudio(6);
			
			Assert.assertEquals("Developer Certification Java",nuevo.getTituloEstudio());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Falló el Ingreso del Estudio del Postulante: " + e.getMessage());
		}
	}

}
