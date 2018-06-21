package com.dospe.gestionbecarios.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dospe.gestionbecarios.model.Asesor;
import com.dospe.gestionbecarios.model.Beca;
import com.dospe.gestionbecarios.service.AsesorService;
import com.dospe.gestionbecarios.service.BecaService;
import com.dospe.gestionbecarios.service.IesService;


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
				Asesor asesor = asesorService.findOne(Long.parseLong(text));
				setValue(asesor);
			}
		});
	}

	
	/**
	 * Show All Becas with Pagination
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/beca", method = RequestMethod.GET)
	public String showAllBecasWithPagination(Model model, Integer offset, Integer maxResults) {
		model.addAttribute("becaList", becaService.findAllPaginated(offset, maxResults));
		model.addAttribute("becaCount", becaService.count());
		model.addAttribute("becaOffset", offset);
		return BECA_LIST_PAGINATED;
//		return "base-definition-2";
	}
	
	@RequestMapping(value="/beca/api/cargar_becas", method=RequestMethod.GET)
	@ResponseBody
	public List<Beca> cargarBecasPost(){
		logger.debug("Listando Becas");
		return becaService.findAll();
	}
	
	@RequestMapping(value = "/beca/api/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Beca getBecaById(@PathVariable("id") Long id) {
		return becaService.findOne(id);
	}


	/**
	 * Save or update Beca
	 * 
	 * @param becaDTO
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/beca/api/guardar", method = RequestMethod.POST)
	@ResponseBody
//	public String saveorUpdateBeca(@ModelAttribute("becaForm") Beca beca, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
	public Map<String, Object> saveorUpdateBeca(@RequestBody Beca beca) {
		Map<String, Object> map = new HashMap<String, Object>();
		String msg;
		msg = becaService.saveOrUpdate(beca);
		map.put("estado", "OK");
		map.put("msg", msg);
		return map;
	}

	/**
	 * Show Add Beca Form
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
