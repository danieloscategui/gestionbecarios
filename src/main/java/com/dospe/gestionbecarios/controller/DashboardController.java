package com.dospe.gestionbecarios.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dospe.gestionbecarios.controller.dto.SearchCriteriaDashboard;
import com.dospe.gestionbecarios.service.BecaService;

@Controller
public class DashboardController {
	
	private static final String BECA_DASHBOARD = "beca-dashboard";
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class); 
	
	@Autowired
	private BecaService becaService;
	
	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getDashboard(Model model){
		logger.debug("getDashboard");
		model.addAttribute("searchCriteriaDashboard", new SearchCriteriaDashboard());
		return BECA_DASHBOARD;
	}
	
	@RequestMapping(value="/dashboard/query", method=RequestMethod.POST)
	public String dashboardQuery(@ModelAttribute("searchCriteriaDashboard") SearchCriteriaDashboard searchCriteriaDashboard, BindingResult result, Model model){
		model.addAttribute("params", searchCriteriaDashboard);
		return BECA_DASHBOARD;
	}
	
	@RequestMapping(value="/dashboard/convocatorias", method=RequestMethod.GET)
	@ResponseBody
	public List<String> getConvocatorias(){
		logger.debug("Buscando convocatorias");
		return null; //becaService.getConvocatorias();
	}
	
	@RequestMapping(value="/dashboard/modalidades", method=RequestMethod.POST)
	@ResponseBody
	public List<String> getModalidades(@RequestBody SearchCriteriaDashboard search){
		logger.debug("Buscando modalidades por convocatoria {}", search.getConvocatoria());
		return null; //becaService.getModalidades(search.getConvocatoria());
	}
	
	@RequestMapping(value="/dashboard/ies", method=RequestMethod.POST)
	@ResponseBody
	public List<String> getIes(@RequestBody SearchCriteriaDashboard search){
		logger.debug("Buscando ies por convocatoria {} y modalidad {}", search.getConvocatoria(), search.getModalidad());
		return null; //becaService.getIes(search.getConvocatoria(), search.getModalidad());
	}
	
	@RequestMapping(value="/dashboard/carreras", method=RequestMethod.POST)
	@ResponseBody
	public List<String> getCarreras(@RequestBody SearchCriteriaDashboard search){
		logger.debug("Buscando carreras por convocatoria {}, modalidad {} e Ies {}", search.getConvocatoria(), search.getModalidad(), search.getIes());
		return null; //becaService.getCarreras(search.getConvocatoria(), search.getModalidad(), search.getIes());
	}
	
}
