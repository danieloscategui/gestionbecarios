package com.dospe.gestionbecarios.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dospe.gestionbecarios.controller.dto.CondicionDTO;
import com.dospe.gestionbecarios.controller.dto.EstadoDTO;
import com.dospe.gestionbecarios.persistence.domain.Condicion;
import com.dospe.gestionbecarios.persistence.domain.Estado;
import com.dospe.gestionbecarios.transactional.service.CondicionService;
import com.dospe.gestionbecarios.transactional.service.EstadoService;

@Controller
public class EstadoController {
	private static final String ESTADO_LIST = "estado-list";
	
	private static final Logger logger = LoggerFactory.getLogger(EstadoController.class);

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CondicionService condicionService;
	
	@RequestMapping(value="/estado", method=RequestMethod.GET)
	public String showEstadoPage(Model model){
		logger.debug("Cargando pagina inicial de estado.");
		model.addAttribute("estados", estadoService.findAll());
		return ESTADO_LIST;
	}
	
	@RequestMapping(value="/estado/get", method=RequestMethod.GET)
	@ResponseBody
	public Collection<Estado> listarEstado(){
		logger.debug("Listando todos los estados");
		return  estadoService.findAll();
	}

	@RequestMapping(value="/estado/get/{idEstado}", method=RequestMethod.GET)
	@ResponseBody
	public Estado getEstado(@PathVariable("idEstado") Long idEstado){
		logger.debug("Getting one estado");
		return  estadoService.findById(idEstado);
	}
	
	@RequestMapping(value="/estado/condicion/{idCondicion}", method=RequestMethod.GET)
	@ResponseBody
	public Condicion getCondicion(@PathVariable("idCondicion") Long idCondicion){
		logger.debug("Getting one Condicion");
		return  condicionService.findById(idCondicion);
	}
	
	@RequestMapping(value="/estado/{idEstado}/condicion", method=RequestMethod.GET)
	@ResponseBody
	public Collection<Condicion> mostrarCondicionPorBeca(@PathVariable("idEstado") Long idEstado){
		logger.debug("Consultando todas las condiciones por determinado estado");
		return  condicionService.findAllByEstado(idEstado);
	}
	
	@RequestMapping(value="/estado/subcondicion/{idCondicion}", method=RequestMethod.GET)
	@ResponseBody
	public Collection<Condicion> mostrarSubCondiciones(@PathVariable("idCondicion") Long idCondicion){
		logger.debug("Consultando todas las subcondiciones por determinada condicion.");
		return condicionService.findAllByCondicion(idCondicion);
	}
	
	@RequestMapping(value="/estado/api/crearEstado", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> crearEstado(@ModelAttribute("estadoDTO") EstadoDTO estadoDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		estadoService.save(new Estado(estadoDTO.getDescripcion()));
		map.put("success", true);
		map.put("msg", "El estado se registro satisfactoriamente.");
		return map;
	}
	
	@RequestMapping(value="/estado/api/actualizarEstado", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> actualizarEstado(@ModelAttribute("estadoDTO") EstadoDTO estadoDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		logger.debug("Comprobando EstadoDTO: " + estadoDTO.getIdEstado() + " - " + estadoDTO.getDescripcion());
		Estado estado = new Estado(); 
		estado = estadoService.findById(estadoDTO.getIdEstado());
		estado.setDescripcion(estadoDTO.getDescripcion());
		estadoService.save(estado);
		map.put("success", true);
		map.put("msg", "El registro se actualizo satisfactoriamente");
		
		return map;
	}
	
	@RequestMapping(value="/estado/condicion/api/crearCondicion", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> crearCondicion(@ModelAttribute("condicionDTO") CondicionDTO condicionDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		Condicion condicion = condicionService.findById(condicionDTO.getIdCondicion());
		Estado estado = estadoService.findById(condicionDTO.getIdEstado());
		
		if(condicion.isNew() && estado != null){
			condicionService.save(new Condicion(condicionDTO.getDescripcion(), estado, condicionDTO.getIdSubCondicion()));
			map.put("success", true);
			map.put("msg", "La condicion se registro satisfactoriamente.");
		} else {
			map.put("error", true);
			map.put("msg", "La condicion: " + condicion.getDescripcion() + " ya existe");
		}
			
		return map;
	}
	
	
	@RequestMapping(value="/estado/condicion/api/actualizarCondicion", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> actualizarCondicion(@ModelAttribute("condicionDTO") CondicionDTO condicionDTO){
		Map<String, Object> map = new HashMap<String, Object>();
		Condicion condicion = condicionService.findById(condicionDTO.getIdCondicion());
		Estado estado = estadoService.findById(condicionDTO.getIdEstado());
		condicion.setDescripcion(condicionDTO.getDescripcion());
		condicion.setEstado(estado);
		condicion.setIdSubCondicion(condicionDTO.getIdSubCondicion());
		condicionService.save(condicion);
		map.put("success", true);
		map.put("msg", "La condicion se registro satisfactoriamente.");
			
		return map;
	}
	
}
