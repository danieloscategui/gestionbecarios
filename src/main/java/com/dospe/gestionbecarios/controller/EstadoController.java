package com.dospe.gestionbecarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.dospe.gestionbecarios.controller.dto.CondicionDTO;
import com.dospe.gestionbecarios.controller.dto.CondicionListDTO;
import com.dospe.gestionbecarios.controller.dto.EstadoDTO;
import com.dospe.gestionbecarios.controller.dto.EstadoListDTO;
import com.dospe.gestionbecarios.persistence.domain.Condicion;
import com.dospe.gestionbecarios.persistence.domain.Estado;
import com.dospe.gestionbecarios.persistence.exception.DuplicateValueException;
import com.dospe.gestionbecarios.transactional.service.CondicionService;
import com.dospe.gestionbecarios.transactional.service.EstadoService;
import com.dospe.gestionbecarios.util.Common;

@RestController
@RequestMapping("/api")
public class EstadoController extends Common{
	
	private static final Logger logger = LoggerFactory.getLogger(EstadoController.class);
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CondicionService condicionService;
	
	@GetMapping("/estado/list")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<EstadoListDTO> listarEstado(){
		logger.debug("Listando todos los estados");
		return estadoService.findAll().stream()
				.map(estado -> convertToDTO(estado))
				.collect(Collectors.toList());
		
	}	

	@PostMapping("/estado")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> crearEstado(@Valid @RequestBody EstadoDTO estadoDTO) {

		boolean estadoExiste = estadoService.existsByDescripcionIgnoreCase(estadoDTO.getDescripcion());
		if (estadoExiste) {
			logger.info("Duplicidad de nomnbre de institución.");
			throw new DuplicateValueException(getMessageSource("atributo.duplicado", new Object[] {estadoDTO.getDescripcion().toUpperCase()}));
		}

		Estado estado = convertToEntity(estadoDTO);
		estadoService.save(estado);
		logger.info("Estado creado.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("message", getMessageSource("record.created"));
		return response;
	}

	@GetMapping("/estado/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public EstadoDTO getEstado(@PathVariable("id") Long id) {
		return modelMapper.map(estadoService.findById(id), EstadoDTO.class);
	}

	@PutMapping("/estado")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> actualizarEstado(@Valid @RequestBody EstadoDTO estadoDTO) {
		Estado estado = convertToEntity(estadoDTO);
		estadoService.save(estado);
		logger.info("Estado actualizado.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("message", getMessageSource("record.updated"));
		return response;
	}
	
	@GetMapping("/estado/{idEstado}/condicion")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody	
	public Map<String, Object> listarTablaCondicion(@PathVariable("idEstado") Long idEstado){
		Map<String, Object> response = new HashMap<String, Object>();
		logger.info("listando todas las condiciones por estado " + idEstado);
		List<CondicionListDTO> condicionTableListDTO = condicionService.findAllByEstado(idEstado)
														.stream()
														.map(condicion -> convertToDTO(condicion))
														.collect(Collectors.toList());
		response.put("data", condicionTableListDTO);
		return response;
	}

	@GetMapping("/estado/{idEstado}/condicion/list")
	@ResponseBody
	public List<CondicionListDTO> listarCondicionPorEstado(@PathVariable("idEstado") Long idEstado){
		logger.info("Consultando todas las condiciones por estado");
		List<Condicion> condiciones = condicionService.findAllByEstado(idEstado);
		return condiciones.stream()
				.map(condicion -> convertToDTO(condicion))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/estado/{idEstado}/condicion/{idCondicion}/list")
	@ResponseBody
	public List<CondicionListDTO> listarSubCondicionePorEstadoYCondicion(@PathVariable("idEstado") Long idEstado,
																		@PathVariable("idCondicion") Long idCondicion){
		logger.info("Consultando todas las subcondiciones por estado y condicion");
		List<Condicion> condiciones = condicionService.findAllByEstadoAndCondicion(idEstado, idCondicion);
		return condiciones.stream()
				.map(condicion -> convertToDTO(condicion))
				.collect(Collectors.toList());
	}
	
	@PostMapping("/condicion")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> crearCondicion(@Valid @RequestBody  CondicionDTO condicionDTO){
		boolean condicionExiste =  condicionService.existsByDescripcionIgnoreCaseAndIdEstado(condicionDTO.getDescripcion(), condicionDTO.getIdEstado());
		if (condicionExiste) {
			logger.info("Duplicidad de nomnbre de condicion.");
			throw new DuplicateValueException(getMessageSource("atributo.duplicado", new Object[] {condicionDTO.getDescripcion().toUpperCase()}));
		}

		Condicion condicion = convertToEntity(condicionDTO);
		condicionService.save(condicion);
		
		logger.info("Condicion creada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("message", getMessageSource("record.created"));
		return response;
	}

	@GetMapping("/condicion/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CondicionDTO getCondicion(@PathVariable("id") Long id) {
		return modelMapper.map(condicionService.findById(id), CondicionDTO.class);
	}
	
	@PutMapping("/condicion")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> updateCondicion(@Valid @RequestBody CondicionDTO condicionDTO) {
		Condicion condicion = convertToEntity(condicionDTO);
		condicionService.save(condicion);
		logger.info("Condicion actualizada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("message", getMessageSource("record.updated"));
		return response;
	}
	
	private EstadoListDTO convertToDTO(Estado estado) {
		return modelMapper.map(estado, EstadoListDTO.class);
	}
	
	private CondicionListDTO convertToDTO(Condicion condicion) {
		return  modelMapper.map(condicion, CondicionListDTO.class);
	}
	
	private Condicion convertToEntity(CondicionDTO condicionDTO) {
		Condicion condicion;
		if (condicionDTO.getId() != null) {
			condicion = condicionService.findById(condicionDTO.getId());
		} else {
			condicion = new Condicion();
		}
		
		condicion.setDescripcion(condicion.getDescripcion());
		condicion.setIdEstado(condicionDTO.getIdEstado());
		condicion.setIdPadre(condicionDTO.getIdPadre());
		
		return condicion;
	}
	
	private Estado convertToEntity(EstadoDTO estadoDTO) {
		Estado estado;
		if (estadoDTO.getId() != null) {
			estado = estadoService.findById(estadoDTO.getId());
		} else {
			estado = new Estado();
		}
		
		estado.setDescripcion(estado.getDescripcion());
		
		return estado;
	}
}
