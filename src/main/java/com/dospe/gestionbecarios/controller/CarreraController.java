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

import com.dospe.gestionbecarios.controller.dto.CarreraDTO;
import com.dospe.gestionbecarios.controller.dto.CarreraListDTO;
import com.dospe.gestionbecarios.persistence.domain.Carrera;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.CarreraService;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {
	
	private static final Logger logger = LoggerFactory.getLogger(CarreraController.class);
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	private CarreraService carreraService;

	@GetMapping({"/beca/{id}"})
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CarreraListDTO> findAllByBeca(@PathVariable("id") Long idBeca){
		logger.info("listando todos las carreras por beca");
		List<Carrera> carreraList = (List<Carrera>) carreraService.findAllByBeca(idBeca);
		return carreraList.stream()
				.map(ies -> convertToDTO(ies))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/beca/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public CarreraDTO create(@PathVariable("id") Long idBeca, @Valid @RequestBody CarreraDTO carreraDTO) {
		boolean carreraExiste = carreraService.findByDescripcion(idBeca, carreraDTO.getDescripcion().toUpperCase()) != null;
		if(carreraExiste) {
			throw new DuplicateValueException("La carrera "+ carreraDTO.getDescripcion()+ " ya existe");
		}
		
		Carrera carrera = modelMapper.map(carreraDTO, Carrera.class);
		carreraService.save(carrera);
		return modelMapper.map(carrera, CarreraDTO.class);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public CarreraDTO edit(@PathVariable("id") Long id) {
		CarreraDTO carreraDTO = modelMapper.map(
									carreraService.findById(id), 
									CarreraDTO.class
								);
		return carreraDTO;
	}

	@PutMapping("/{id}")
	@ResponseBody
	public CarreraDTO update(@PathVariable("id") Long id, @Valid @RequestBody CarreraDTO carreraDTO) {
		Carrera carrera = carreraService.findById(id);
		carrera.setId(id);
		carrera.setDescripcion(carreraDTO.getDescripcion());
		carrera.setSemestreEgreso(carreraDTO.getSemestreEgreso());
		carrera.setIdBeca(carreraDTO.getIdBeca());
		carreraService.save(carrera);
		return modelMapper.map(carrera, CarreraDTO.class);
	}
	
	private CarreraListDTO convertToDTO(Carrera carrera) {
		CarreraListDTO carreraListDTO = modelMapper.map(carrera, CarreraListDTO.class);
		return carreraListDTO;
	}
}
