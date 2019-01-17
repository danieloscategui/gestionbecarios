package com.dospe.gestionbecarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dospe.gestionbecarios.controller.dto.IesDTO;
import com.dospe.gestionbecarios.controller.dto.IesListDTO;
import com.dospe.gestionbecarios.persistence.domain.Ies;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.IesService;

@RestController
@RequestMapping("/api/ies")
public class IesController {
	
	private static final Logger logger = LoggerFactory.getLogger(IesController.class);
//	private static final String IES_FORM = "ies-form";
//	private static final String IES_LIST_PAGINATED = "ies-list-paginated";
//	private static final String IES_REDIRECT = "redirect:/ies/";
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private IesService iesService;
//	@Autowired
//	private SedeEstudioService sedeEstudioService;

//	@GetMapping({"/", ""})
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<IesListDTO> findAll(){
//		logger.info("listando todos las ies");
//		List<Ies> iesList = (List<Ies>) iesService.findAll();
//		return iesList.stream()
//				.map(ies -> convertToDTO(ies))
//				.collect(Collectors.toList());
//	}
	
	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> listarIes(HttpServletRequest request){
		Map<String, Object> result = new HashMap<String, Object>();
		logger.info("listando todas las IES en un map");
//		int page = request.getParameter("page") == null? 1 : Integer.parseInt(request.getParameter("page"));
//		int rows = request.getParameter("rows") == null? 10 : Integer.parseInt(request.getParameter("rows"));
		List<Ies> iesList = (List<Ies>) iesService.findAll();
		List<IesListDTO> iesListDTO = iesList.stream()
				.map(ies -> convertToDTO(ies))
				.collect(Collectors.toList());
		result.put("data", iesListDTO);
		return result;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody IesDTO iesDTO) {
		
		boolean iesExiste = iesService.existsByNombreIgnoreCase(iesDTO.getNombre());
		if(iesExiste) {
			logger.info("Duplicidad de nomnbre de institución.");
			throw new DuplicateValueException("La institución "+iesDTO.getNombre().toUpperCase()+ " ya existe.");
		}
		
		Ies ies = convertoToEntity(iesDTO);
		iesService.save(ies);
		logger.info("Institución creada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("iesDTO", modelMapper.map(ies, IesDTO.class));
		return response;
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public IesDTO get(@PathVariable("id") Long id) {
		IesDTO iesDTO = modelMapper.map(
									iesService.findById(id), 
									IesDTO.class
								);
		return iesDTO;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> update(@PathVariable("id") Long id, @Valid @RequestBody IesDTO iesDTO) {
		Ies ies = convertoToEntity(iesDTO);
		iesService.save(ies);
		logger.info("Institución actualizada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("iesDTO", modelMapper.map(ies, IesDTO.class));
		return response;
	}
	
	private IesListDTO convertToDTO(Ies ies) {
		IesListDTO iesListDTO = modelMapper.map(ies, IesListDTO.class);
		return iesListDTO;
	}
	
	private Ies convertoToEntity(IesDTO iesDTO) {
		Ies ies;
		if (iesDTO.getId() != null) {
			ies = iesService.findById(iesDTO.getId());
		} else {
			ies = new Ies();
		}
		ies.setNombre(iesDTO.getNombre());
		ies.setIdTipoIes(iesDTO.getIdTipoIes());
		ies.setIdTipoGestion(iesDTO.getIdTipoGestion());
		ies.setContacto(iesDTO.getContacto());
		ies.setTelefono(iesDTO.getTelefono());
		ies.setCorreo(iesDTO.getCorreo());
		
		return ies;
	}
}
