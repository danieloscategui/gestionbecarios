package com.dospe.gestionbecarios.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dospe.gestionbecarios.controller.dto.BecarioDTO;
import com.dospe.gestionbecarios.controller.dto.BecarioListDTO;
import com.dospe.gestionbecarios.persistence.domain.Asignacion;
import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.transactional.service.AsignacionService;
import com.dospe.gestionbecarios.transactional.service.BecaService;
import com.dospe.gestionbecarios.transactional.service.BecarioService;
import com.dospe.gestionbecarios.transactional.service.EstadoService;

@RestController
@RequestMapping("/api/becario")
public class BecarioRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(BecarioRestController.class);
	
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
	@Qualifier("asignacionService")
	private AsignacionService asignacionService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping({"/beca/{id}"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> findAllByBeca(@PathVariable("id") Long idBeca, HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("listando todos los becarios por beca: "+ idBeca);
//		int page = request.getParameter("page") == null? 1 : Integer.parseInt(request.getParameter("page"));
//		int rows = request.getParameter("rows") == null? 10 : Integer.parseInt(request.getParameter("rows"));
		
		List<BecarioListDTO> becariosDTO = becarioService.findBecariosPorBeca(idBeca).stream()
											.map(becario -> convertToDTO(becario))
											.collect(Collectors.toList());
		result.put("data", becariosDTO);
		return result;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public BecarioDTO showBecario(@PathVariable("id") Long id){
		logger.debug("Passing by showBecario");
		Becario becario = becarioService.findById(id);
		return modelMapper.map(becario, BecarioDTO.class);
	}

	@RequestMapping(value="/becario/api/beca/{idBeca}", method=RequestMethod.GET)
	@ResponseBody
	public Collection<Becario> showBecariosPorBeca(@PathVariable("id") Long idBeca, @PathVariable("dni") String dni, HttpServletRequest request){
		logger.debug("Show Becarios Por Beca");
		return becarioService.findBecariosPorBeca(idBeca);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> update(@Valid @RequestBody BecarioDTO becarioDTO) {
		//becarioService.save(becario);
		System.out.println(becarioDTO);
		Asignacion asignacion = new Asignacion();
		asignacion.setIdCarrera(becarioDTO.getIdCarrera());
		asignacion.setIdSedeEstudio(becarioDTO.getIdSedeEstudio());
		asignacion.setIdAsesor(becarioDTO.getIdAsesor());
		Becario becario = convertoToEntity(becarioDTO);
		becarioService.save(becario, asignacion);
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("idBeca", becarioDTO.getIdBeca());
		return response;
		
	}	
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
		return modelMapper.map(becario, BecarioListDTO.class);
	}
	
	private Becario convertoToEntity(BecarioDTO becarioDTO) {
		Becario becario;
		if (becarioDTO.getId() != null) {
			becario = becarioService.findById(becarioDTO.getId());
		} else {
			becario = new Becario();
		}
		becario.setId(becarioDTO.getId());
		becario.setDni(becarioDTO.getDni());
		becario.setNombres(becarioDTO.getNombres().toUpperCase());
		becario.setApellidos(becarioDTO.getApellidos().toUpperCase());
		becario.setFechaNacimiento(becarioDTO.getFechaNacimiento());
		becario.setEdad(becarioDTO.getEdad());
		becario.setSexo(becarioDTO.getSexo());
		becario.setCorreoPersonal(becarioDTO.getCorreoPersonal().toUpperCase());
		becario.setTelefonos(becarioDTO.getTelefonos());
		becario.setDireccion(becarioDTO.getDireccion().toUpperCase());
		becario.setContacto(becarioDTO.getContacto().toUpperCase());
		becario.setContactoTelefono(becarioDTO.getContactoTelefono().toUpperCase());
		becario.setNumeroExpediente(becarioDTO.getNumeroExpediente().toUpperCase());
		becario.setResolucionAdjudicacion(becarioDTO.getResolucionAdjudicacion().toUpperCase());
		becario.setResolucionAdjudicacionFecha(becarioDTO.getResolucionAdjudicacionFecha());
		becario.setRegionProcedencia(becarioDTO.getRegionProcedencia().toUpperCase());
		becario.setProvinciaProcedencia(becarioDTO.getProvinciaProcedencia().toUpperCase());
		becario.setDistritoProcedencia(becarioDTO.getDistritoProcedencia().toUpperCase());
		becario.setIdEstado(becarioDTO.getIdEstado());
		becario.setIdCondicion(becarioDTO.getIdCondicion());
		becario.setDocumentoCulminacion(becarioDTO.getDocumentoCulminacion().toUpperCase());
		becario.setResolucionPerdidaBeca(becarioDTO.getResolucionPerdidaBeca().toUpperCase());
		becario.setObservaciones(becarioDTO.getObservaciones().toUpperCase());
		return becario;
	}
	

}
