package com.dospe.gestionbecarios.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.transactional.service.BecarioService;

@Controller
public class IndexController {
	
	@Autowired
	private BecarioService becarioService;
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/")
	public String showWelcomePage() {
		logger.info("show welcome page");
//		return "base-definition2";
//		return "asesor-list";
//		return "asesor-list-2";
//		return "asesor-list-page";
//		return "becario-list";
		return "base-starter";
	}
	
	@RequestMapping("/becarios")
	public String showBecarioLista() {
		return "becario-lista";
	}
	
	@RequestMapping("/ies")
	public String showBecarios() {
		logger.info("show welcome page");
		return "ies-mant";
	}
	
	@RequestMapping("/test")
	public String showBecarioPage() {
		return "becario-list-page";
	}
	
	@RequestMapping("/becario/{id}")
	public String mostrarBecarioPorId(@PathVariable("id") Long id, Model model) {
		logger.info("buscar por id: " + id);
		Becario becario = becarioService.findById(id);
		logger.info("Becario data: " + becario.getFullName()	);
		return "becario-form";
	}
}