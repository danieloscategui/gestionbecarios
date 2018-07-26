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

import com.dospe.gestionbecarios.model.Ies;
import com.dospe.gestionbecarios.service.IesService;
import com.dospe.gestionbecarios.service.TipoGestionService;
import com.dospe.gestionbecarios.service.TipoIesService;

@Controller
public class IesController {
	
	private static final String IES_FORM = "ies-form";
	private static final String IES_LIST_PAGINATED = "ies-list-paginated";
	private static final String IES_REDIRECT = "redirect:/ies/";
	
	@Autowired
	private IesService iesService;

	@Autowired
	private TipoGestionService tipoGestionService;
	
	@Autowired
	private TipoIesService tipoIesService;
	
	/**
	 * List IES
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ies", method=RequestMethod.GET)
	public String showAllIes(Model model, Integer offset, Integer maxResults){
		model.addAttribute("iesList", iesService.findAllPaginated(offset, maxResults));
		model.addAttribute("iesCount", iesService.count());
		model.addAttribute("iesOffset", offset);
		return IES_LIST_PAGINATED; 
	}
	
	/**
	 * Save or update IES
	 * @param iesDto
	 * @param result
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/ies", method=RequestMethod.POST)
	public String saveOrUpdateIes(@ModelAttribute("iesForm") Ies ies, BindingResult result, Model model, final RedirectAttributes redirectAttributes){
		
		if (result.hasErrors()){
//			populateDefaultModel(model);
			return IES_FORM;
		} else {
			
			iesService.saveOrUpdate(ies);
			
			return IES_REDIRECT; //+ies.getId();
		}
	}

	
	/**
	 * Show Add IES Form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ies/add", method=RequestMethod.GET)
	public String showAddIesForm(Model model){
		Ies ies = new Ies();
		//set default value
		model.addAttribute("iesForm", ies);
		populateDefaultModel(model);
		return IES_FORM;
	}
	
	/**
	 * Show Update IES Form
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ies/{id}/update", method=RequestMethod.GET)
	public String showUpdateIesForm(@PathVariable("id") Long id,  Model model){
		Ies ies = iesService.findOne(id);
		model.addAttribute("iesForm", ies);
		populateDefaultModel(model);
		return IES_FORM;
	}
	
	/**
	 * Delete IES -- to implement
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="/ies/{id}/delete", method=RequestMethod.POST)
	public String deleteIes(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes){
		//check previous data -- implements
//		iesService.delete(id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "IES has been deleted");
		return "redirect:/ies";
	}
	
	/**
	 * Show IES - to implement
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/ies/{id}", method=RequestMethod.GET)
	public String showIES(@PathVariable("id") Long id, Model model){
		Ies ies = iesService.findOne(id);
		if (ies == null){
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "IES not found");
		} 
		model.addAttribute("ies", ies);
		
		return IES_FORM;//make new ies.show just to show data
	}
	
	/**
	 * Populate Default Model
	 * @param model
	 */
	private void populateDefaultModel(Model model) {
		
		model.addAttribute("opcionesTipoIes", tipoIesService.findAll());
		model.addAttribute("opcionesTipoGestion", tipoGestionService.findAll());

	}
}
