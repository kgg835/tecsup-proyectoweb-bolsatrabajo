package com.proyecto.test;

import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

import com.proyecto.exception.DAOExcepcion;
import com.proyecto.negocio.GestionAviso;
public class testAviso {
	@Test
	public void insertartest(){
		GestionAviso negocio= new GestionAviso();
		try{
			GregorianCalendar gc=new GregorianCalendar(2012,9,10);
			GregorianCalendar gc1=new GregorianCalendar(2012,10,10);
			negocio.insertar(1,1, "programador junior sin experiencia", gc.getTime(), gc1.getTime());


		}catch(DAOExcepcion e){
			Assert.fail("fallo"+e.getMessage());
		}
	
	}
}
