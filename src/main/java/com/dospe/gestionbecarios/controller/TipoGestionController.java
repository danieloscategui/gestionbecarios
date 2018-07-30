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

import com.dospe.gestionbecarios.controller.dto.TipoGestionDTO;
import com.dospe.gestionbecarios.controller.dto.TipoGestionListDTO;
import com.dospe.gestionbecarios.persistence.domain.TipoGestion;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.TipoGestionService;

@RestController
@RequestMapping("/api/tipoGestion")
public class TipoGestionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TipoGestionController.class);
//	private static final String IES_FORM = "ies-form";
//	private static final String IES_LIST_PAGINATED = "ies-list-paginated";
//	private static final String IES_REDIRECT = "redirect:/ies/";
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("tipoGestionService")
	private TipoGestionService tipoGestionService;

	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<TipoGestionListDTO> findAll(){
		logger.info("Listando todos los tipo de gestion.");
		List<TipoGestion> tipoGestionList = (List<TipoGestion>) tipoGestionService.findAll();
		return tipoGestionList.stream()
				.map(tipoGestion -> convertToDTO(tipoGestion))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public TipoGestionDTO create(@Valid @RequestBody TipoGestionDTO tipoGestionDTO) {
		boolean tipoGestionExiste = tipoGestionService.findByDescripcion(tipoGestionDTO.getDescripcion().toUpperCase()) != null;
		if(tipoGestionExiste) {
			throw new DuplicateValueException("El nombre "+tipoGestionDTO.getDescripcion()+ " ya existe");
		}
		
		TipoGestion tipoGestion = modelMapper.map(tipoGestionDTO, TipoGestion.class);
		tipoGestionService.save(tipoGestion);
		return modelMapper.map(tipoGestion, TipoGestionDTO.class);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public TipoGestionDTO edit(@PathVariable("id") Long id) {
		TipoGestionDTO tipoGestionDTO = modelMapper.map(
									tipoGestionService.findById(id), 
									TipoGestionDTO.class
								);
		return tipoGestionDTO;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public TipoGestionDTO update(@PathVariable("id") Long id, @Valid @RequestBody TipoGestionDTO tipoGestionDTO) {
		TipoGestion tipoGestion = tipoGestionService.findById(id);
		tipoGestion.setDescripcion(tipoGestion.getDescripcion());
		tipoGestionService.save(tipoGestion);
		return modelMapper.map(tipoGestion, TipoGestionDTO.class);
	}
	
	private TipoGestionListDTO convertToDTO(TipoGestion tipoGestion) {
		TipoGestionListDTO tipoGestionListDTO = modelMapper.map(tipoGestion, TipoGestionListDTO.class);
		return tipoGestionListDTO;
	}
}
