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
		logger.info("show welcome page");
//		return "base-definition2";
//		return "asesor-list";
//		return "asesor-list-2";
		return "asesor-list-page";
	}
	
	@RequestMapping("/becario")
	public String showBecarioPage() {
		return "becario-list-page";
	}
	
	@RequestMapping("/becarioForm")
	public String showBecarioFormPage() {
		return "becario-form";
	}
	
}