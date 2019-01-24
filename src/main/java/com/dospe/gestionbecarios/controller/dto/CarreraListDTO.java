package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class CarreraListDTO implements Serializable{

	private static final long serialVersionUID = -6472329304551726730L;
	private Long id;
	private String descripcion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
