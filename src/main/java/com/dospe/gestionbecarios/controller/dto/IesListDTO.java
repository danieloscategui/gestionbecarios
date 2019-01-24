package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;
import java.util.List;

public class IesListDTO implements Serializable{

	private static final long serialVersionUID = -510840466304607999L;
	private Long id;
	private String nombre;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
