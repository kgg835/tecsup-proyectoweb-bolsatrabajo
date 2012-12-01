package com.proyecto.presentacion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {
	
	@RequestMapping(value = "/index")	
	protected ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return new ModelAndView("inicio");
	}

}
