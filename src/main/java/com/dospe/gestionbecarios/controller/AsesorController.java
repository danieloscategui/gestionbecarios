package com.dospe.gestionbecarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dospe.gestionbecarios.model.Asesor;
import com.dospe.gestionbecarios.service.AsesorService;


@Controller
public class AsesorController {
	
	private static final String ASESOR_FORM = "asesor-form";
	private static final String ASESOR_LIST_PAGINATED = "asesor-list-paginated";
	private static final String ASESOR_REDIRECT = "redirect:/asesor/";
	
	
	@Autowired
	private AsesorService asesorService;
	
	/**
	 * List Asesor Paginated
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/asesor", method=RequestMethod.GET )
	public String showAllAsesor(Model model, Integer offset, Integer maxResults){
		model.addAttribute("asesorList", asesorService.findAllPaginated(offset, maxResults));
		model.addAttribute("asesorCount", asesorService.count());
		model.addAttribute("asesorOffset", offset);
		return ASESOR_LIST_PAGINATED;

	}
	
	/**
	 * Save or update Asesor
	 * @param asesorDTO
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/asesor", method=RequestMethod.POST)
	public String saveOrUpdateAsesor(@ModelAttribute("asesorForm") Asesor asesor, BindingResult result, final RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return ASESOR_FORM;
		} else {
			asesorService.saveOrUpdate(asesor);
		}
		return ASESOR_REDIRECT;
	}
	
	/**
	 * Show Add Asesor Form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/asesor/add", method=RequestMethod.GET)
	public String showAddAsesorForm(Model model){
		Asesor asesor = new Asesor();
		model.addAttribute("asesorForm", asesor);
		return ASESOR_FORM;
	}
	
	/**
	 * Show Update Asesor Form
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/asesor/{id}/update", method=RequestMethod.GET)
	public String showUpdateAsesorForm(@PathVariable("id") Long id, Model model){
		Asesor asesor = asesorService.findOne(id);
		model.addAttribute("asesorForm", asesor);
//		populateDefaultModel(model);
		return ASESOR_FORM;
	}
	
	/**
	 * Populate Default Model
	 * https://howtoprogramwithjava.com/how-to-fix-duplicate-data-from-hibernate-queries/
	 */
	private void populateDefaultModel(){
		
	}
}
