package com.dospe.gestionbecarios.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dospe.gestionbecarios.controller.form.BecarioEstado;
import com.dospe.gestionbecarios.persistence.domain.Beca;
import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.persistence.domain.BecarioView;
import com.dospe.gestionbecarios.persistence.domain.Estado;
import com.dospe.gestionbecarios.persistence.domain.Sexo;
import com.dospe.gestionbecarios.transactional.service.BecaService;
import com.dospe.gestionbecarios.transactional.service.BecarioService;
import com.dospe.gestionbecarios.transactional.service.EstadoService;

@Controller
public class BecarioController {
	
	private static final String BECARIO_LIST_PAGINATED = "becario-list-paginated";
	private static final String BECARIO_FORM = "becario-form";
	private static final String BECARIO_SHOW = "becario-show";
	private static final String BECARIO_FORM_ESTADO = "becario-form-estado";
	private static final String BECARIO_RESULTADO_BUSQUEDA_POR_DNI = "becario-resultado-busqueda-por-dni";
	
	private static final Logger logger = LoggerFactory.getLogger(BecarioController.class);
	
	@Autowired
	private BecarioService becarioService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private BecaService becaService;

	private Collection<Beca> listaBecas = new ArrayList<Beca>();
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		
		binder.registerCustomEditor(Beca.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Beca beca = becaService.findById(Long.parseLong(text));
				setValue(beca);
			}
		});
		
		binder.registerCustomEditor(Estado.class, new PropertyEditorSupport(){
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				Estado estado = estadoService.findById(Long.parseLong(text)); 
				setValue(estado);
			}
		});
	}
	
	/**
	 * Show All Becarios
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/becario", method=RequestMethod.GET)
	public String showBecarioPage(Model model){
//		model.addAttribute("becarioList", becarioService.showAll());
		logger.debug("Passing by showBecarioPage");
		model.addAttribute("becas", becaService.findAll());
		return BECARIO_LIST_PAGINATED;
	}

	/**
	 * Show Becarios por Beca
	 * @param idBeca
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/becario/api/beca/{idBeca}", method=RequestMethod.GET)
	@ResponseBody
	public Collection<BecarioView> showBecariosPorBeca(@PathVariable("idBeca") Long idBeca){
//		model.addAttribute("becarioList", becarioService.findBecariosPorBecaPaginated(idBeca, offset, maxResults));
//		model.addAttribute("beca", becaService.findOne(idBeca));
//		model.addAttribute("becarioCount", becarioService.countByBeca(idBeca));
//		model.addAttribute("becarioOffset", offset);
		logger.debug("Show Becarios Por Beca");
		return becarioService.findBecariosPorBeca(idBeca);
	}
	
	/**
	 * Save or Update Becario
	 * @param becarioDTO
	 * @param result
	 * @param redirectAttributes
	 * @return
	@RequestMapping(value="/becario", method=RequestMethod.POST)
	public String saveOrUpdateBecario(@ModelAttribute("becarioForm") Becario becario, BindingResult result, Model model, final RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			populateDefaultModel(model);
			return BECARIO_FORM;
		} else {
			becarioService.saveOrUpdate(becario);
		}
		return "redirect:/becario/"+ String.valueOf(becario.getIdBecario()) + "/show";
	}
	 */
	
	
	/**
	 * Formulario Cambiar Estado 
	 */
	@RequestMapping(value="/becario/{idBecario}/updateEstado", method=RequestMethod.GET)
	public String updateBecarioEstadoForm(@PathVariable("idBecario") Long idBecario, Model model){
		Becario becario = becarioService.findById(idBecario);
		
		model.addAttribute("listEstado", estadoService.findAll());
//		model.addAttribute("listEstadoDos", becarioService.getListEstadoDos(becario.getEstadoUno().getIdEstadoUno()));
//		model.addAttribute("listEstadoTres", becarioService.getListEstadoTres(becario.getEstadoDos()));
		model.addAttribute("becarioForm", becario);
		return BECARIO_FORM_ESTADO;
	}
	
	/**
	 * Formulario Actualizar Becario
	 */
	@RequestMapping(value="/becario/{idBecario}/update",method=RequestMethod.GET)
	public String showUpdateBecarioForm(@PathVariable("idBecario") Long idBecario, Model model){
		Becario becario = becarioService.findById(idBecario);
		model.addAttribute("becarioForm", becario);
		populateDefaultModel(model);
		return BECARIO_FORM;
	}
	
	/**
	 * Metodo Actualizar Estado POST
	 */
	@RequestMapping(value="/becario/updateEstado", method=RequestMethod.POST)
	public String updateBecarioEstado(@ModelAttribute("becarioForm") Becario becario){
		BecarioEstado becarioEstado = new BecarioEstado();
//		becarioEstado.setEstadoUno(becario.getEstadoUno().getIdEstadoUno());
//		becarioEstado.setEstadoDos(becario.getEstadoDos());
//		becarioEstado.setEstadoTres(becario.getEstadoTres());
//		becarioService.updateBecarioEstado(becario.getIdBecario(), becarioEstado, becario.getObservaciones());
		return "redirect:/becario/beca/" + String.valueOf(becario.getAsignacion().getCarrera().getBeca().getIdBeca());
	}
	
	/**
	 * Show Add Becario Form
	 */
	@RequestMapping(value="/becario/add", method=RequestMethod.GET)
	public String showAddBecarioForm(Model model){
		Becario becario = new Becario();
		model.addAttribute("becarioForm", becario);
		populateDefaultModel(model);
		return BECARIO_FORM;
	}
	
	/**
	 * Buscar Becario por DNI y retornar una lista
	 */
	@RequestMapping(value="/becario/{dni}/buscar", method=RequestMethod.GET)
	public String buscarBecarioPorDni(@PathVariable("dni") String dni, Model model){
		if (dni.isEmpty() || dni == null){
			model.addAttribute("msg", "Ingrese DNI");
			return "redirect:/";
		}
		
		Collection<Becario> becariosEncontrados = becarioService.findByDNI(dni);
		if(becariosEncontrados.isEmpty()){
			model.addAttribute("msg", "No existe DNI");
			return "redirect:/";
		}
		model.addAttribute("becariosEncontrados", becariosEncontrados);
		return BECARIO_RESULTADO_BUSQUEDA_POR_DNI;
	}
	
	
	/**
	 * Buscar Becario por DNI y retornar una lista
	 */
	@RequestMapping(value="/becario/{id}/show", method=RequestMethod.GET)
	public String mostrarBecario(@PathVariable("id") Long id, Model model){
		model.addAttribute("becario", becarioService.findById(id));
		return BECARIO_SHOW;
	}
	
	
	
	@RequestMapping(value="/becario/returnBeca", method=RequestMethod.GET)
	public String returnBeca(Model model){
		return "redirect:/";
	}
	
	/*
	@RequestMapping(value="/becario/estadoUno", method=RequestMethod.GET)
	@ResponseBody
	public List<EstadoUno> getListEstadoUno(){
		logger.debug("Buscando Lista Estado Uno");
		return becarioService.getJdbcEstadoUno();
	}

	@RequestMapping(value="/becario/estadoDos", method=RequestMethod.GET)
	@ResponseBody
	public List<EstadoDos> getListEstadoDos(@RequestParam(name="idEstadoUno", required=true) Integer idEstadoUno){
		logger.debug("Buscando Lista Estado Dos - idEstadoUno {}", idEstadoUno);
		return becarioService.getJdbcEstadoDos(idEstadoUno);
	}
	
	@RequestMapping(value="/becario/estadoTres", method=RequestMethod.GET)
	@ResponseBody
	public List<EstadoTres> getListEstadoTres(@RequestParam(name="idEstadoDos") Integer idEstadoDos){
		logger.debug("Buscanod Lista Estado Dos - idEstadoDos {}", idEstadoDos);
		return becarioService.getJdbcEstadoTres(idEstadoDos);
	}
	*/
	
	/**
	 * Populate Default Model
	 */
	protected final void populateDefaultModel(Model model){
		
		if (listaBecas.isEmpty()){
			listaBecas = becaService.findAll();
		}
		
//		model.addAttribute("listEstadoUno", becarioService.getListEstadoUno());
		model.addAttribute("listaBecas", listaBecas);
		model.addAttribute("becarioSexo", Sexo.values());
		
	}
}
