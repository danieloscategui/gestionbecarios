package com.dospe.gestionbecarios.controller;

import java.util.List;
import java.util.stream.Collectors;

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

	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<IesListDTO> findAll(){
		logger.info("listando todos las ies");
		List<Ies> iesList = (List<Ies>) iesService.findAll();
		return iesList.stream()
				.map(ies -> convertToDTO(ies))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public IesDTO create(@Valid @RequestBody IesDTO iesDTO) {
		boolean iesExiste = iesService.existsByNombreIgnoreCase(iesDTO.getNombre());
		if(iesExiste) {
			throw new DuplicateValueException("El nombre "+iesDTO.getNombre()+ " ya existe");
		}
		
		Ies ies = modelMapper.map(iesDTO, Ies.class);
		iesService.save(ies);
		return modelMapper.map(ies, IesDTO.class);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public IesDTO edit(@PathVariable("id") Long id) {
		IesDTO iesDTO = modelMapper.map(
									iesService.findById(id), 
									IesDTO.class
								);
		return iesDTO;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public IesDTO update(@PathVariable("id") Long id, @Valid @RequestBody IesDTO iesDTO) {
		Ies ies = iesService.findById(id);
		ies.setNombre(iesDTO.getNombre());
		iesService.save(ies);
		return modelMapper.map(ies, IesDTO.class);
	}
	
	private IesListDTO convertToDTO(Ies ies) {
		IesListDTO iesListDTO = modelMapper.map(ies, IesListDTO.class);
		return iesListDTO;
	}
}
