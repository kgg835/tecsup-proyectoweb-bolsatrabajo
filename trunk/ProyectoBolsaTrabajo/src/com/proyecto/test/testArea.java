package com.proyecto.test;

import junit.framework.Assert;

import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.GestionArea;

public class testArea {
	
	@Test
	public void insertartest(){
		GestionArea negocio= new GestionArea();
		try{
			negocio.insertar("INGENIERIA");


		}catch(DAOExcepcion e){
			Assert.fail("fallo"+e.getMessage());
		}
	
	}
}
