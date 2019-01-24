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

import com.dospe.gestionbecarios.controller.dto.CarreraDTO;
import com.dospe.gestionbecarios.controller.dto.CarreraListDTO;
import com.dospe.gestionbecarios.controller.dto.CarreraTableListDTO;
import com.dospe.gestionbecarios.persistence.domain.Carrera;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.CarreraService;
import com.dospe.gestionbecarios.util.Common;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController extends Common {

	private static final Logger logger = LoggerFactory.getLogger(CarreraController.class);

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private CarreraService carreraService;

	@GetMapping("/beca/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> listarTablaCarrerasPorBeca(@PathVariable("id") Long idBeca, HttpServletRequest request) {
		logger.info("listando todos las carreras por beca: " + idBeca);
		// int page = request.getParameter("page") == null? 1 :
		// Integer.parseInt(request.getParameter("page"));
		// int rows = request.getParameter("rows") == null? 10 :
		// Integer.parseInt(request.getParameter("rows"));
		List<CarreraTableListDTO> carreraListDTO = carreraService.findAllByBeca(idBeca).stream()
				.map(carrera -> convertToTableListDTO(carrera)).collect(Collectors.toList());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", carreraListDTO);
		return result;
	}

	@GetMapping("/beca/{id}/list")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<CarreraListDTO>  listarCarrerasPorBeca(@PathVariable("id") Long idBeca, HttpServletRequest request) {
		return carreraService.findAllByBeca(idBeca).stream()
							.map(carrera -> convertToListDTO(carrera)).collect(Collectors.toList());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody CarreraDTO carreraDTO) {
		boolean carreraExiste = carreraService.existsByIdBecaAndDescripcionIgnoreCase(carreraDTO.getIdBeca(),
				carreraDTO.getDescripcion());
		if (carreraExiste) {// "La carrera "+ carreraDTO.getDescripcion()+ " ya existe"
			throw new DuplicateValueException(
					getMessageSource("atributo.duplicado", new Object[] { carreraDTO.getDescripcion().toUpperCase() }));
		}

		Carrera carrera = convertToEntity(carreraDTO);
		carreraService.save(carrera);
		logger.info("Carrera creada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("carreraDTO", modelMapper.map(carrera, CarreraDTO.class));
		response.put("message", getMessageSource("record.created"));
		return response;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public CarreraDTO edit(@PathVariable("id") Long id) {
		return modelMapper.map(carreraService.findById(id), CarreraDTO.class);
	}

	@PutMapping
	@ResponseBody
	public Map<String, Object> update(@Valid @RequestBody CarreraDTO carreraDTO) {
		Carrera carrera = convertToEntity(carreraDTO);
		carreraService.save(carrera);
		logger.info("Carrera actualizada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("carreraDTO", modelMapper.map(carrera, CarreraDTO.class));
		response.put("message", getMessageSource("record.updated"));
		return response;
	}

	private CarreraListDTO convertToListDTO(Carrera carrera) {
		return modelMapper.map(carrera, CarreraListDTO.class);
	}

	private CarreraTableListDTO convertToTableListDTO(Carrera carrera) {
		return modelMapper.map(carrera, CarreraTableListDTO.class);
	}
	
	private Carrera convertToEntity(CarreraDTO carreraDTO) {
		Carrera carrera;
		if (carreraDTO.getId() != null) {
			carrera = carreraService.findById(carreraDTO.getId());
		} else {
			carrera = new Carrera();
		}
		carrera.setDescripcion(carreraDTO.getDescripcion());
		carrera.setSemestreEgreso(carreraDTO.getSemestreEgreso());
		carrera.setIdBeca(carreraDTO.getIdBeca());

		return carrera;
	}
}
