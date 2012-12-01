package com.proyecto.presentacion.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.proyecto.exception.DAOExcepcion;
import com.proyecto.modelo.Aviso;
import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.negocio.service.AvisoService;
import com.proyecto.negocio.service.UsuarioService;



@Controller
public class AvisoController {
	
	@Autowired
	private AvisoService avisoService;
	
	
	
	@RequestMapping(value = "/aviso" )	
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Dentro de aviso");


	
		
	
		return new ModelAndView("/avisos_ofertante");
	}


	@RequestMapping(value = "/aviso_grabar" )	
	protected ModelAndView aviso(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Calendar c2 = new GregorianCalendar();
		Aviso avi=new Aviso();
		avi.setIdOfertante(1);
		avi.setId_area(1);
		avi.setTitulo(request.getParameter("titulo"));
		avi.setFec_publicacion(c2.getTime());
		avi.setFec_caduc(c2.getTime());
		avi.setDescripcion(request.getParameter("descripcion"));
		
		try {
			avisoService.insertar(avi);
		} catch (DAOExcepcion e) {
			return new ModelAndView("/avisos_ofertante", "mensaje", e.getMessage());
		}
		
		return new ModelAndView("/avisos_ofertante","mensaje","El aviso se grabo correctamente");
	}
	
	
	
	@RequestMapping(value = "/listarAvisos")	
	protected ModelAndView postulaciones(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		Collection<Aviso> listaravisos=new ArrayList<Aviso>();
		
try {
	listaravisos=avisoService.listarAvisos();

} catch (Exception e) {
	// TODO: handle exception
}
	
	request.setAttribute("avisos", listaravisos);	
		return new ModelAndView("inicio");
		
		
	}
	
	@RequestMapping(value = "/mostrar_aviso" )	
	protected ModelAndView mostraraviso(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Calendar c2 = new GregorianCalendar();
		Aviso avi=new Aviso();
		avi.setIdOfertante(1);
		avi.setId_area(1);
		avi.setTitulo(request.getParameter("titulo"));
		avi.setFec_publicacion(c2.getTime());
		avi.setFec_caduc(c2.getTime());
		avi.setDescripcion(request.getParameter("descripcion"));
		String titulo=request.getParameter("titutlo");
		try {
			avisoService.insertar(avi);
		} catch (DAOExcepcion e) {
			return new ModelAndView("/avisos_ofertante", "mensaje", e.getMessage());
		}
		
		return new ModelAndView("/avisos_ofertante","mensaje","El aviso se grabo correctamente");
	}
	
	

}
