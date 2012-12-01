package com.proyecto.presentacion.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.modelo.HistorialPostulaciones;
import com.proyecto.negocio.service.PostulacionesService;


@Controller
public class PostulacionesController {

@Autowired
private PostulacionesService postulacionesService;

public void setPostulacionesService(PostulacionesService postulacionesService){
	this.postulacionesService=postulacionesService;
	
}

	@RequestMapping(value = "/historialPostulaciones")	
	protected ModelAndView postulaciones(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		Collection<HistorialPostulaciones> listapostulaciones=new ArrayList<HistorialPostulaciones>();
		
try {
	listapostulaciones=postulacionesService.listarPostulaciones();

} catch (Exception e) {
	// TODO: handle exception
}
	
	request.setAttribute("postulaciones", listapostulaciones);	
		return new ModelAndView("postulaciones");
		
		
	}
	}