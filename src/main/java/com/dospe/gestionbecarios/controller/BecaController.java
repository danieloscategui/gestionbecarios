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

import com.dospe.gestionbecarios.controller.dto.BecaDTO;
import com.dospe.gestionbecarios.controller.dto.BecaListDTO;
import com.dospe.gestionbecarios.controller.dto.BecaTableListDTO;
import com.dospe.gestionbecarios.persistence.domain.Beca;
import com.dospe.gestionbecarios.transactional.service.BecaService;
import com.dospe.gestionbecarios.util.Common;

@RestController
@RequestMapping("api/beca")
public class BecaController extends Common {

	private static final Logger logger = LoggerFactory.getLogger(BecaController.class);

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BecaService becaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Map<String, Object> listarTableBecas(HttpServletRequest request) {
		Map<String, Object> response = new HashMap<String, Object>();
		logger.info("listando todos las becas para datatable");
		// int page = request.getParameter("page") == null? 1 :
		// Integer.parseInt(request.getParameter("page"));
		// int rows = request.getParameter("rows") == null? 10 :
		// Integer.parseInt(request.getParameter("rows"));

		List<Beca> becasList = (List<Beca>) becaService.findAll();
		List<BecaTableListDTO> becaTableListDTO = becasList.stream().map(beca -> convertToTableListDTO(beca))
				.collect(Collectors.toList());
		response.put("data", becaTableListDTO);
		return response;
	}
	
	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<BecaListDTO> listarBecas() {
		return becaService.findAll().stream().map(beca -> convertToListDTO(beca))
											 .collect(Collectors.toList());
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Map<String, Object> create(@Valid @RequestBody BecaDTO becaDTO) {
		// boolean becaExiste =
		// becaService.findByConvocatoriaAndModalidad(becaDTO.getConvocatoria().toUpperCase(),
		// becaDTO.getModalidad().toUpperCase) != null;
		// if(becaExiste) {
		// throw new DuplicateValueException(getMessageSource("atributo.duplicado", new
		// Object[] {becaDTO.getModalidad().toUpperCase()}));
		// }

		Beca beca = convertToEntity(becaDTO);
		becaService.save(beca);
		logger.info("Beca creada");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("becaDTO", modelMapper.map(beca, BecaDTO.class));
		response.put("message", getMessageSource("record.created"));
		return response;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public BecaDTO edit(@PathVariable("id") Long id) {
		return  modelMapper.map(becaService.findById(id), BecaDTO.class);
	}

	@PutMapping
	@ResponseBody
	public Map<String, Object> update(@Valid @RequestBody BecaDTO becaDTO) {
		Beca beca = convertToEntity(becaDTO);
		becaService.save(beca);
		logger.info("beca actualizada.");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("success", true);
		response.put("becaDTO", modelMapper.map(beca, BecaDTO.class));
		response.put("message", getMessageSource("record.updated"));
		return response;
		
	}

	private BecaTableListDTO convertToTableListDTO(Beca beca) {
		return  modelMapper.map(beca, BecaTableListDTO.class);
	}
	
	private BecaListDTO convertToListDTO(Beca beca) {
		return modelMapper.map(beca, BecaListDTO.class);
	}

	private Beca convertToEntity(BecaDTO becaDTO) {
		Beca beca;
		if (becaDTO.getId() != null) {
			logger.info("Beca tiene id");
			beca = becaService.findById(becaDTO.getId());
		} else {
			logger.info("Beca no tiene id");
			beca = new Beca();
		}

		beca.setConvocatoria(becaDTO.getConvocatoria());
		beca.setModalidad(becaDTO.getModalidad());
		beca.setInicio(becaDTO.getInicio());
		beca.setTermino(becaDTO.getTermino());

		return beca;

	}
}