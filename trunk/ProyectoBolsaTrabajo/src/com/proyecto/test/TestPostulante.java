package com.proyecto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.proyecto.modelo.Postulante;
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
		GestionPostulante obj = new GestionPostulante();

	}
}
