package com.dospe.gestionbecarios.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dospe.gestionbecarios.controller.dto.BecarioListDTO;
import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.persistence.domain.BecarioView;
import com.dospe.gestionbecarios.transactional.service.BecaService;
import com.dospe.gestionbecarios.transactional.service.BecarioService;
import com.dospe.gestionbecarios.transactional.service.EstadoService;

@RestController
@RequestMapping("/api/becario")
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
	
	@GetMapping({"/beca/{id}"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> findAllByBeca(@PathVariable("id") Long idBeca, HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("listando todos los becarios por beca: "+ idBeca);
		int page = request.getParameter("page") == null? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null? 10 : Integer.parseInt(request.getParameter("rows"));
		
		Page<Becario> becarioPage = becarioService.findAllByBeca(idBeca, page, rows);
		
		List<BecarioListDTO> becarios = becarioPage.getContent().stream()
											.map(becario -> convertToDTO(becario))
											.collect(Collectors.toList());
		
		result.put("total", becarioPage.getTotalElements());
		result.put("rows", becarios);
		
		return result;

	}
	
	
	@RequestMapping(value="/becario", method=RequestMethod.GET)
	public String showBecarioPage(Model model){
//		model.addAttribute("becarioList", becarioService.showAll());
		logger.debug("Passing by showBecarioPage");
		model.addAttribute("becas", becaService.findAll());
		return "BECARIO_LIST_PAGINATED";
	}

	@RequestMapping(value="/becario/api/beca/{idBeca}", method=RequestMethod.GET)
	@ResponseBody
	public Collection<BecarioView> showBecariosPorBeca(@PathVariable("id") Long idBeca, @PathVariable("dni") String dni, HttpServletRequest request){
//		model.addAttribute("becarioList", becarioService.findBecariosPorBecaPaginated(idBeca, offset, maxResults));
//		model.addAttribute("beca", becaService.findOne(idBeca));
//		model.addAttribute("becarioCount", becarioService.countByBeca(idBeca));
//		model.addAttribute("becarioOffset", offset);
		logger.debug("Show Becarios Por Beca");
		return becarioService.findBecariosPorBeca(idBeca);
	}
	
	
//	@RequestMapping(value="/becario/{dni}/buscar", method=RequestMethod.GET)
	@GetMapping({"{dni}/beca/{id}"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> buscarBecarioPorDniYBeca(@PathVariable("id") Long idBeca, @NotNull(message="Ingrese DNI") @PathVariable("dni") String dni, HttpServletRequest request){
		
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("listando todos los becarios por beca: "+ idBeca + " y dni: " + dni);
		int page = request.getParameter("page") == null? 1 : Integer.parseInt(request.getParameter("page"));
		int rows = request.getParameter("rows") == null? 10 : Integer.parseInt(request.getParameter("rows"));
		
		Page<Becario> becarioPage = becarioService.findAllByBecaAndDni(idBeca, dni, page, rows);
		
		List<BecarioListDTO> becarios = becarioPage.getContent().stream()
											.map(becario -> convertToDTO(becario))
											.collect(Collectors.toList());
		
		result.put("total", becarioPage.getTotalElements());
		result.put("rows", becarios);
		
		return result;
		
	}
	
	
	/**
	 * Buscar Becario por DNI y retornar una lista
	 */
	@RequestMapping(value="/becario/{id}/show", method=RequestMethod.GET)
	public String mostrarBecario(@PathVariable("id") Long id, Model model){
		model.addAttribute("becario", becarioService.findById(id));
		return "BECARIO_SHOW";
	}
	
	
	private BecarioListDTO convertToDTO(Becario becario) {
		BecarioListDTO becarioListDTO = modelMapper.map(becario, BecarioListDTO.class);
		return becarioListDTO;
	}
}
