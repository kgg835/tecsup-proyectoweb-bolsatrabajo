package com.proyecto.test;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Ofertante;
import com.proyecto.negocio.GestionPostulante;
import com.proyecto.negocio.Gestionofertante;

public class testofertante {
	
	public void test() {
		// fail("Not yet implemented");
	}

	//@Test
	public void insertartest(){
		Gestionofertante negocio= new Gestionofertante();
		try{
			negocio.insertar("4576958","bryang", "thrthrth@hotmail.com", "gfnfgn", "uil", "liy");


		}catch(DAOExcepcion e){
			Assert.fail("fallo"+e.getMessage());
		}
	
	}
	//@Test
	public void buscar(){

		Gestionofertante nego= new Gestionofertante();
		try{
			Ofertante x=nego.obtener(5);
			System.out.println(x.getCorreo());
	
		}catch(DAOExcepcion e)
		{
			Assert.fail("fallo"+ e.getMessage());
		}
	}
	
	//@Test
	public void eliminar(){

		Gestionofertante nego= new Gestionofertante();
		try{
			nego.eliminar(4);
			
	
		}catch(DAOExcepcion e)
		{
			Assert.fail("fallo"+ e.getMessage());
		}
	}

	@Test
	public void listar(){

		Gestionofertante nego= new Gestionofertante();
		try{
			Collection<Ofertante> listado=nego.listar();
	for (Ofertante ofertante : listado) {
		Ofertante respuesta=new Ofertante();


		System.out.println(ofertante.getRuc()+ofertante.getRazonsocial()+ofertante.getCorreo()+ofertante.getDescempresa()+ofertante.getUsuario()+ofertante.getPassword());
		
	}
		}catch(DAOExcepcion e)
		{
			Assert.fail("fallo"+ e.getMessage());
		}
	}
	//@Test
	public void previsualizarDatosDelPostulante() {
		@SuppressWarnings("unused")
		GestionPostulante obj = new GestionPostulante();

	}
}
