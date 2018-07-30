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

import com.dospe.gestionbecarios.controller.dto.AsesorAddDTO;
import com.dospe.gestionbecarios.controller.dto.AsesorEditDTO;
import com.dospe.gestionbecarios.controller.dto.AsesorListDTO;
import com.dospe.gestionbecarios.persistence.domain.Asesor;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.AsesorService;


@RestController
@RequestMapping("/api/asesor")
public class AsesorController {
	
	private static final Logger logger = LoggerFactory.getLogger(AsesorController.class);
//	private static final String ASESOR_FORM = "asesor-form";
//	private static final String ASESOR_LIST_PAGINATED = "asesor-list-paginated";
//	private static final String ASESOR_REDIRECT = "redirect:/asesor/";
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("asesorService")
	private AsesorService asesorService;
	
	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AsesorListDTO> findAll(){
		logger.info("listando todos los asesores");
		List<Asesor> asesores = (List<Asesor>) asesorService.findAll();
		return asesores.stream()
				.map(asesor -> convertToDTO(asesor))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public AsesorEditDTO create(@Valid @RequestBody AsesorAddDTO asesorDTO) {
		boolean asesorExiste = asesorService.findByNombre(asesorDTO.getNombre().toUpperCase()) != null;
		if(asesorExiste) {
			throw new DuplicateValueException("El nombre "+asesorDTO.getNombre()+ " ya existe");
		}
		
		Asesor asesor = modelMapper.map(asesorDTO,Asesor.class);
		asesorService.save(asesor);
		return modelMapper.map(asesor, AsesorEditDTO.class);
	}
	

	@GetMapping("/{id}")
	@ResponseBody
	public AsesorEditDTO edit(@PathVariable("id") Long id) {
		AsesorEditDTO asesorDTO = modelMapper.map(
									asesorService.findById(id), 
									AsesorEditDTO.class
								);
		return asesorDTO;
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public AsesorEditDTO update(@PathVariable("id") Long id, @Valid @RequestBody AsesorEditDTO asesorDTO) {
		Asesor asesor = asesorService.findById(id);
		asesor.setNombre(asesorDTO.getNombre());
		asesorService.save(asesor);
		return modelMapper.map(asesor, AsesorEditDTO.class);
	}
	
	private AsesorListDTO convertToDTO(Asesor asesor) {
		AsesorListDTO asesorListDTO = modelMapper.map(asesor, AsesorListDTO.class);
		return asesorListDTO;
	}

}
