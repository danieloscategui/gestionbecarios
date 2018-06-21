package com.dospe.gestionbecarios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method={RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT}, headers = "Accept=application/json")
	public String redirect(){
		return "redirect:/beca/";
	}
	
}
