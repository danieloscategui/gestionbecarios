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
import com.dospe.gestionbecarios.controller.dto.IesTableListDTO;
import com.dospe.gestionbecarios.persistence.domain.Ies;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.IesService;
import com.dospe.gestionbecarios.util.Common;

@RestController
@RequestMapping("/api/ies")
public class IesController extends Common {

	private static final Logger logger = LoggerFactory.getLogger(IesController.class);
	

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private IesService iesService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> listarTablaIes(HttpServletRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
		logger.info("listando todas las IES");
		// int page = request.getParameter("page") == null? 1 :
		// Integer.parseInt(request.getParameter("page"));
		// int rows = request.getParameter("rows") == null? 10 :
		// Integer.parseInt(request.getParameter("rows"));
		List<IesTableListDTO> iesTableListDTO =  iesService.findAll().stream().map(ies -> convertToTableListDTO(ies)).collect(Collectors.toList());
		response.put("data", iesTableListDTO);
		return response;
	}

	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<IesListDTO> listarIes(HttpServletRequest request) {
		return iesService.findAll().stream().map(ies -> convertToListDTO(ies))
											.collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody IesDTO iesDTO) {

		boolean iesExiste = iesService.existsByNombreIgnoreCase(iesDTO.getNombre());
		if (iesExiste) {
			logger.info("Duplicidad de nomnbre de institución.");
			throw new DuplicateValueException(getMessageSource("atributo.duplicado", new Object[] {iesDTO.getNombre().toUpperCase()}));
		}

		Ies ies = convertoToEntity(iesDTO);
		iesService.save(ies);
		logger.info("Institución creada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("iesDTO", modelMapper.map(ies, IesDTO.class));
		response.put("message", getMessageSource("record.created"));
		return response;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public IesDTO get(@PathVariable("id") Long id) {
		return modelMapper.map(iesService.findById(id), IesDTO.class);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> update(@Valid @RequestBody IesDTO iesDTO) {
		Ies ies = convertoToEntity(iesDTO);
		iesService.save(ies);
		logger.info("Institución actualizada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("iesDTO", modelMapper.map(ies, IesDTO.class));
		response.put("message", getMessageSource("record.updated"));
		return response;
	}

	private IesListDTO convertToListDTO(Ies ies) {
		return modelMapper.map(ies, IesListDTO.class);
	}
	
	private IesTableListDTO convertToTableListDTO(Ies ies) {
		return modelMapper.map(ies, IesTableListDTO.class);
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
