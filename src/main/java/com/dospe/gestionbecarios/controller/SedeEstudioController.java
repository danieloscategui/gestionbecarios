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
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.dospe.gestionbecarios.controller.dto.SedeEstudioDTO;
import com.dospe.gestionbecarios.controller.dto.SedeEstudioListDTO;
import com.dospe.gestionbecarios.controller.dto.SedeEstudioTableListDTO;
import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.SedeEstudioService;
import com.dospe.gestionbecarios.util.Common;

@RestController
@RequestMapping("/api/sedeEstudio")
public class SedeEstudioController extends Common {
	
	private static final Logger logger = LoggerFactory.getLogger(SedeEstudioController.class);
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("sedeEstudioService")
	private SedeEstudioService sedeEstudioService;

	@GetMapping("/ies/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> listarTablaSedesPorIes(@PathVariable("id") Long idIes, HttpServletRequest request){
		logger.info("Listando todas las sedes por ies: " + idIes);
//		int page = request.getParameter("page") == null? 1 : Integer.parseInt(request.getParameter("page"));
//		int rows = request.getParameter("rows") == null? 10 : Integer.parseInt(request.getParameter("rows"));
		
		List<SedeEstudioTableListDTO> sedeEstudioTableListDTO = sedeEstudioService.findAllByIes(idIes).stream()
														.map(becario -> convertToTableListDTO(becario))
														.collect(Collectors.toList());

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", sedeEstudioTableListDTO);
		return result;
	}
	
	@GetMapping("/ies/{id}/list")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SedeEstudioListDTO> listarSedesPorIes(@PathVariable("id") Long idIes, HttpServletRequest request){
		return sedeEstudioService.findAllByIes(idIes).stream()
				.map(becario -> convertToListDTO(becario))
				.collect(Collectors.toList());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody SedeEstudioDTO sedeEstudioDTO) {
		boolean sedeEstudioExiste = sedeEstudioService.existsBySedeIgnoreCase(sedeEstudioDTO.getSede(), sedeEstudioDTO.getIdIes());
		if(sedeEstudioExiste) {
			logger.info("Duplicidad de sede de estudio");
			throw new DuplicateValueException(getMessageSource("atributo.duplicado", new Object[] {sedeEstudioDTO.getSede().toUpperCase()}));
		}
		
		SedeEstudio sedeEstudio = convertToEntity(sedeEstudioDTO);
		sedeEstudioService.save(sedeEstudio);
		logger.info("Sede de estudio creada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("sedeEstudioDTO", modelMapper.map(sedeEstudio, SedeEstudioDTO.class));
		response.put("message", getMessageSource("record.created"));
		return response;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public SedeEstudioDTO edit(@PathVariable("id") Long id) {
		return  modelMapper.map(
								sedeEstudioService.findById(id), 
								SedeEstudioDTO.class
								);
	}

	@PutMapping
	@ResponseBody
	public Map<String, Object> update(@Valid @RequestBody SedeEstudioDTO sedeEstudioDTO) {
		SedeEstudio sedeEstudio = convertToEntity(sedeEstudioDTO);
		sedeEstudioService.save(sedeEstudio);
		logger.info("Sede de estudio actualizada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("sedeEstudioDTO", modelMapper.map(sedeEstudio, SedeEstudioDTO.class));
		response.put("message", getMessageSource("record.updated"));
		return response;
	}
	
	private SedeEstudioListDTO convertToListDTO(SedeEstudio sedeEstudio) {
		return modelMapper.map(sedeEstudio, SedeEstudioListDTO.class);
	}
	
	private SedeEstudioTableListDTO convertToTableListDTO(SedeEstudio sedeEstudio) {
		return  modelMapper.map(sedeEstudio, SedeEstudioTableListDTO.class);
	}
	
	private SedeEstudio convertToEntity(SedeEstudioDTO sedeEstudioDTO) {
		SedeEstudio sedeEstudio;
		if (sedeEstudioDTO.getId() != null) {
			sedeEstudio = sedeEstudioService.findById(sedeEstudioDTO.getId());
		} else {
			sedeEstudio = new SedeEstudio();
		}
		sedeEstudio.setIdIes(sedeEstudioDTO.getIdIes());
		sedeEstudio.setRegion(sedeEstudioDTO.getRegion());
		sedeEstudio.setSede(sedeEstudioDTO.getSede());
		sedeEstudio.setContacto(sedeEstudioDTO.getContacto());
		sedeEstudio.setTelefono(sedeEstudioDTO.getTelefono());
		sedeEstudio.setCorreo(sedeEstudioDTO.getCorreo());
		
		return sedeEstudio;
	}
}
