package com.proyecto.test;

import org.junit.Test;

import com.proyecto.negocio.GestionPostulante;

public class TestPostulante {

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void registrarPostulanteExitoso() {
		GestionPostulante obj = new GestionPostulante();
		obj.registrarPostulante("Anderson", "Roman");
	}

	public void previsualizarDatosDelPostulante() {
		@SuppressWarnings("unused")
		GestionPostulante obj = new GestionPostulante();

	}
}
