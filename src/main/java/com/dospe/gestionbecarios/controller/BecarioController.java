package com.dospe.gestionbecarios.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dospe.gestionbecarios.controller.dto.BecarioListDTO;
import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.transactional.service.BecaService;
import com.dospe.gestionbecarios.transactional.service.BecarioService;
import com.dospe.gestionbecarios.transactional.service.EstadoService;

//@RequestMapping("/becario")
public class BecarioController {
	
//	private static final String BECARIO_LIST_PAGINATED = "becario-list-paginated";
//	private static final String BECARIO_FORM = "becario-form";
//	private static final String BECARIO_SHOW = "becario-show";
//	private static final String BECARIO_FORM_ESTADO = "becario-form-estado";
//	private static final String BECARIO_RESULTADO_BUSQUEDA_POR_DNI = "becario-resultado-busqueda-por-dni";
	
	private static final Logger logger = LoggerFactory.getLogger(BecarioController.class);
	
	@Autowired
	@Qualifier("becarioService")
	private BecarioService becarioService;
	
	@Autowired
	@Qualifier("estadoService")
	private EstadoService estadoService;
	
	@Autowired
	@Qualifier("becaService")
	private BecaService becaService;

	@Autowired
	private ModelMapper modelMapper;
	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String mostrarBecarioPorId(@PathVariable("id") Long id, Model model) {
		logger.info("buscar por id");
		model.addAttribute("becario", becarioService.findById(id));
		return "becario-form";
	}
	
	private BecarioListDTO convertToDTO(Becario becario) {
		BecarioListDTO becarioListDTO = modelMapper.map(becario, BecarioListDTO.class);
		return becarioListDTO;
	}
}
