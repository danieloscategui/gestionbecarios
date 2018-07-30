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

import com.dospe.gestionbecarios.controller.dto.BecaDTO;
import com.dospe.gestionbecarios.controller.dto.BecaListDTO;
import com.dospe.gestionbecarios.persistence.domain.Beca;
import com.dospe.gestionbecarios.transactional.service.BecaService;


@RestController
@RequestMapping("api/beca")
public class BecaController {

//	private static final String BECA_LIST_PAGINATED = "beca-list-paginated";
//	private static final String BECA_FORM = "beca-form";
//	private static final String BECA_REDIRECT = "redirect:/beca/";

	private static final Logger logger = LoggerFactory.getLogger(BecaController.class); 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BecaService becaService;
	
	@GetMapping({"/", ""})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<BecaListDTO> findAll(){
		logger.info("listando todos las ies");
		List<Beca> becas = (List<Beca>) becaService.findAll();
		return becas.stream()
				.map(beca -> convertToDTO(beca))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public BecaDTO create(@Valid @RequestBody BecaDTO becaDTO) {
//		boolean iesExiste = iesService.findByNombre(iesDTO.getNombre().toUpperCase()) != null;
//		if(iesExiste) {
//			throw new DuplicateValueException("El nombre "+iesDTO.getNombre()+ " ya existe");
//		}
		
		Beca beca = modelMapper.map(becaDTO, Beca.class);
		becaService.save(beca);
		return modelMapper.map(beca, BecaDTO.class);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public BecaDTO edit(@PathVariable("id") Long id) {
		BecaDTO becaDTO = modelMapper.map(
									becaService.findById(id), 
									BecaDTO.class
								);
		return becaDTO;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public BecaDTO update(@PathVariable("id") Long id, @Valid @RequestBody BecaDTO becaDTO) {
		Beca beca = becaService.findById(id);
		beca.setConvocatoria(becaDTO.getConvocatoria());
		beca.setModalidad(becaDTO.getModalidad());
		beca.setInicio(becaDTO.getInicio());
		beca.setTermino(becaDTO.getTermino());
		becaService.save(beca);
		return modelMapper.map(beca, BecaDTO.class);
	}

	private BecaListDTO convertToDTO(Beca beca) {
		BecaListDTO becaListDTO = modelMapper.map(beca, BecaListDTO.class);
		return becaListDTO;
	}

}
