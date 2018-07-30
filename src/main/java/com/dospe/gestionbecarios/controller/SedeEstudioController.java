package com.dospe.gestionbecarios.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;
import com.dospe.gestionbecarios.transactional.service.SedeEstudioService;

@RestController
@RequestMapping("/api/sedeEstudio")
public class SedeEstudioController {
	
	private static final Logger logger = LoggerFactory.getLogger(SedeEstudioController.class);
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("sedeEstudioService")
	private SedeEstudioService sedeEstudioService;

	@GetMapping({"/ies/{id}"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SedeEstudioListDTO> findAllByIes(@PathVariable("id") Long idIes){
		logger.info("Listando todas las sedes por ies.");
		List<SedeEstudio> sedeEstudioList = (List<SedeEstudio>) sedeEstudioService.findAllByIes(idIes);
		return sedeEstudioList.stream()
				.map(tipoIes -> convertToDTO(tipoIes))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/ies/{id}/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public SedeEstudioDTO create(@PathVariable("id") Long idIes, @Valid @RequestBody SedeEstudioDTO sedeEstudioDTO) {
//		boolean sedeEstudioExiste = sedeEstudioService.findByDescripcion(tipoIesDTO.getDescripcion().toUpperCase()) != null;
//		if(sedeEstudioExiste) {
//			throw new DuplicateValueException("El nombre "+tipoIesDTO.getDescripcion()+ " ya existe");
//		}
		
		SedeEstudio sedeEstudio = modelMapper.map(sedeEstudioDTO, SedeEstudio.class);
		sedeEstudioService.save(sedeEstudio);
		return modelMapper.map(sedeEstudio, SedeEstudioDTO.class);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public SedeEstudioDTO edit(@PathVariable("id") Long id) {
		SedeEstudioDTO sedeEstudioDTO = modelMapper.map(
									sedeEstudioService.findById(id), 
									SedeEstudioDTO.class
								);
		return sedeEstudioDTO;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public SedeEstudioDTO update(@PathVariable("id") Long id, @Valid @RequestBody SedeEstudioDTO sedeEstudioDTO) {
		SedeEstudio sedeEstudio = sedeEstudioService.findById(id);
		sedeEstudio.setIdIes(sedeEstudioDTO.getIdIes());
		sedeEstudio.setRegion(sedeEstudio.getRegion());
		sedeEstudio.setSede(sedeEstudio.getSede());
		sedeEstudioService.save(sedeEstudio);
		return modelMapper.map(sedeEstudio, SedeEstudioDTO.class);
	}
	
	private SedeEstudioListDTO convertToDTO(SedeEstudio sedeEstudio) {
		SedeEstudioListDTO sedeEstudioListDTO = modelMapper.map(sedeEstudio, SedeEstudioListDTO.class);
		return sedeEstudioListDTO;
	}
}
