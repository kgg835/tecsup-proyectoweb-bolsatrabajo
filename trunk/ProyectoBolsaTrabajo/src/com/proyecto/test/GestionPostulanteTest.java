package com.proyecto.test;

import org.junit.Assert;
import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Postulante;
import com.proyecto.negocio.GestionPostulante;

public class GestionPostulanteTest {

	@Test
	public void insertarTest() {
		GestionPostulante negocio = new GestionPostulante();
		try {
			negocio.insertar("Lucho","111111");
			
			Postulante nuevo=negocio.obtener(21);
			Assert.assertEquals("111111",nuevo.getDni());
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}


}
