package com.proyecto.test;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;
import java.util.Collection;                                                
import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.negocio.GestionPostulaciones;



public class TestPostulacion {



	@Test
	public void listarTest() {

		GestionPostulaciones negocio = new GestionPostulaciones();

		try {
			Collection<HistorialPostulaciones> listado = negocio.listarpostulaciones();

			System.out.println(listado.size());

			Assert.assertTrue(listado.size() > 0);

		} catch (DAOExcepcion e) {

			Assert.fail("Falló el listado: " + e.getMessage());

		}

	}}
