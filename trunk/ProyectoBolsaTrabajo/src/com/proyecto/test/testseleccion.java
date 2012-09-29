package com.proyecto.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.negocio.GestionSeleccion;
import com.proyecto.negocio.Gestionofertante;

public class testseleccion {
	@Test
	public void insertartest(){
		GestionSeleccion negocio= new GestionSeleccion();
		try{
			negocio.insertar(2,1,1);


		}catch(DAOExcepcion e){
			Assert.fail("fallo"+e.getMessage());
		}
	
	}
	
	
	
	public void listar(){

		GestionSeleccion nego= new GestionSeleccion();
		try{
			Collection<Ofertante> listado=nego.listar();
	for (Ofertante ofertante : listado) {
		System.out.println(ofertante.getRazonsocial());
	}
		}catch(DAOExcepcion e)
		{
			Assert.fail("fallo"+ e.getMessage());
		}
	}
}
