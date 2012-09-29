package com.proyecto.test;

import org.junit.Test;

import junit.framework.Assert;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.GestionArea;
import com.proyecto.negocio.Gestionofertante;

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
