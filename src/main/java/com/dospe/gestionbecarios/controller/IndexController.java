package com.dospe.gestionbecarios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String showWelcomePage() {
		return "base-starter";
	}
	
	@RequestMapping("/becarios")
	public String showBecarioLista() {
		return "becario-lista";
	}
	
	@RequestMapping("/ies")
	public String showIesPage() {
		return "ies-mant";
	}
	
	@RequestMapping("/beca")
	public String showBecaPage() {
		return "beca-mant";
	}

	@RequestMapping("/condicion")
	public String showCondicionPage() {
		return "condicion-mant";
	}
	
}