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

import com.dospe.gestionbecarios.controller.dto.TipoIesDTO;
import com.dospe.gestionbecarios.controller.dto.TipoIesListDTO;
import com.dospe.gestionbecarios.persistence.domain.TipoIes;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.TipoIesService;

@RestController
@RequestMapping("/api/tipoIes")
public class TipoIesController {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoIesController.class);
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("tipoIesService")
	private TipoIesService tipoIesService;

	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<TipoIesListDTO> findAll(){
		logger.info("Listando todos los tipo de ies.");
		List<TipoIes> tipoIesList = (List<TipoIes>) tipoIesService.findAll();
		return tipoIesList.stream()
				.map(tipoIes -> convertToDTO(tipoIes))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public TipoIesDTO create(@Valid @RequestBody TipoIesDTO tipoIesDTO) {
		boolean tipoIesExiste = tipoIesService.findByDescripcion(tipoIesDTO.getDescripcion().toUpperCase()) != null;
		if(tipoIesExiste) {
			throw new DuplicateValueException("El nombre "+tipoIesDTO.getDescripcion()+ " ya existe");
		}
		
		TipoIes tipoIes = modelMapper.map(tipoIesDTO, TipoIes.class);
		tipoIesService.save(tipoIes);
		return modelMapper.map(tipoIes, TipoIesDTO.class);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public TipoIesDTO edit(@PathVariable("id") Long id) {
		TipoIesDTO tipoIesDTO = modelMapper.map(
									tipoIesService.findById(id), 
									TipoIesDTO.class
								);
		return tipoIesDTO;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public TipoIesDTO update(@PathVariable("id") Long id, @Valid @RequestBody TipoIesDTO tipoIesDTO) {
		TipoIes tipoIes = tipoIesService.findById(id);
		tipoIes.setDescripcion(tipoIes.getDescripcion());
		tipoIesService.save(tipoIes);
		return modelMapper.map(tipoIes, TipoIesDTO.class);
	}
	
	private TipoIesListDTO convertToDTO(TipoIes tipoIes) {
		TipoIesListDTO tipoIesListDTO = modelMapper.map(tipoIes, TipoIesListDTO.class);
		return tipoIesListDTO;
	}
}
