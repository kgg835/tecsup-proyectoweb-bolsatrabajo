package com.proyecto.test;

import junit.framework.Assert;

import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.GestionPuesto;

public class TestPuestoLaboral {
	@Test
	public void insertartest(){
		GestionPuesto negocio= new GestionPuesto();
		try{
			negocio.insertar(1,"ZZZZ");


		}catch(DAOExcepcion e){
			Assert.fail("fallo"+e.getMessage());
		}
	
	}
}
