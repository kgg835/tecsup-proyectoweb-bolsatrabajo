package com.proyecto.test;
import org.junit.Assert;
import org.junit.Test;


import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Presentacion;
import com.proyecto.negocio.GestionPresentacion;

public class TestGestionPresentacion {

	@Test
	public void insertarTest() {
		GestionPresentacion negocio = new GestionPresentacion();
		try {
			negocio.insertar("Soy un jfafdggdgsdgdfgfdgdgdgdag");
			
			Presentacion nuevo=negocio.obtener(8);
//			Assert.assertEquals("1000ac",nuevo.getDescripcionPres();
			
		} catch (DAOExcepcion e) {
			Assert.fail("Fallo la inserción: " + e.getMessage());
		}
	}
	
}
