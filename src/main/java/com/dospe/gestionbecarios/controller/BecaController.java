package com.dospe.gestionbecarios.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dospe.gestionbecarios.persistence.domain.Asesor;
import com.dospe.gestionbecarios.persistence.domain.Beca;
import com.dospe.gestionbecarios.transactional.service.AsesorService;
import com.dospe.gestionbecarios.transactional.service.BecaService;
import com.dospe.gestionbecarios.transactional.service.IesService;


@Controller
public class BecaController {

	private static final String BECA_LIST_PAGINATED = "beca-list-paginated";
	private static final String BECA_FORM = "beca-form";
	private static final String BECA_REDIRECT = "redirect:/beca/";

	private static final Logger logger = LoggerFactory.getLogger(BecaController.class); 
	
	@Autowired
	private BecaService becaService;

	@Autowired
	private IesService iesService;

	@Autowired
	private AsesorService asesorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		
//		binder.registerCustomEditor(Ies.class, new PropertyEditorSupport(){
//			@Override
//			public void setAsText(String text) throws IllegalArgumentException {
//				Ies ies = iesService.findOne(Long.parseLong(text));
//				setValue(ies);
//			}
//		});
		
		binder.registerCustomEditor(Asesor.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Asesor asesor = asesorService.findById(Long.parseLong(text));
				setValue(asesor);
			}
		});
	}

	
	/**
	 * Show All Becas
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/beca", method = RequestMethod.GET)
	public String showAllBecasWithPagination(Model model) {
		model.addAttribute("becaList", becaService.findAll());
		return BECA_LIST_PAGINATED;
	}
	
	@GetMapping("/beca/api/cargar_becas")
	@ResponseStatus(code=HttpStatus.OK)
	@ResponseBody
	public Collection<Beca> listarBecas(){
		logger.debug("Listando Becas");
		return becaService.findAll();
	}
	
	@RequestMapping(value = "/beca/api/get/{id}", method = RequestMethod.GET)
	@GetMapping("/beca/api/get/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	@ResponseBody
	public Beca getBecaById(@PathVariable("id") Long id) {
		return becaService.findById(id);
	}


	/**
	 * Save or update Beca
	 * 
	 * @param becaDTO
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/beca/api/guardar")
	@ResponseBody
//	public String saveorUpdateBeca(@ModelAttribute("becaForm") Beca beca, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
	public Map<String, Object> saveorUpdateBeca(@RequestBody Beca beca) {
		Map<String, Object> map = new HashMap<String, Object>();
		becaService.save(beca);
		map.put("estado", "OK");
		return map;
	}

	/**
	 * showBecariosPorBeca
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/beca/api/mostrarBecarios/{idBeca}", method = RequestMethod.GET)
	public String showBecariosPorBeca(@PathVariable("id") Long id) {
		return "redirect:/becario/beca/{idBeca}"+ String.valueOf(id);
	}


	@RequestMapping(value = "/beca/reporteExcel", method = RequestMethod.GET, produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
	public ModelAndView becaReporteExcel(HttpServletRequest request, HttpServletResponse response) {
		// String typeReport = request.getParameter("type");

		//List<VistaBecasEstado> becasList = becaService.getVistaBecas();

		return null;//new ModelAndView(new ExcelBecasReportView(), "becasList", becasList);

	}

}
