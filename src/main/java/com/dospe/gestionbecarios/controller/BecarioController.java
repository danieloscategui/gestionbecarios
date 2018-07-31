package com.dospe.gestionbecarios.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public List<BecarioListDTO> findAllByBeca(@PathVariable("id") Long idBeca){
		logger.info("listando todos los becarios por beca");
		List<Becario> becarioList = (List<Becario>) becarioService.findAllByBeca(idBeca);
		return becarioList.stream()
				.map(becario-> convertToDTO(becario))
				.collect(Collectors.toList());
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
	public Collection<BecarioView> showBecariosPorBeca(@PathVariable("idBeca") Long idBeca){
//		model.addAttribute("becarioList", becarioService.findBecariosPorBecaPaginated(idBeca, offset, maxResults));
//		model.addAttribute("beca", becaService.findOne(idBeca));
//		model.addAttribute("becarioCount", becarioService.countByBeca(idBeca));
//		model.addAttribute("becarioOffset", offset);
		logger.debug("Show Becarios Por Beca");
		return becarioService.findBecariosPorBeca(idBeca);
	}
	
	
	@RequestMapping(value="/becario/{dni}/buscar", method=RequestMethod.GET)
	public String buscarBecarioPorDni(@PathVariable("dni") String dni, Model model){
		if (dni.isEmpty() || dni == null){
			model.addAttribute("msg", "Ingrese DNI");
			return "redirect:/";
		}
		
		Collection<Becario> becariosEncontrados = becarioService.findByDNI(dni);
		if(becariosEncontrados.isEmpty()){
			model.addAttribute("msg", "No existe DNI");
			return "redirect:/";
		}
		model.addAttribute("becariosEncontrados", becariosEncontrados);
		return "BECARIO_RESULTADO_BUSQUEDA_POR_DNI";
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
