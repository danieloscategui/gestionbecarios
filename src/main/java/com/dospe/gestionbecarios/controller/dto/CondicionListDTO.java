package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class CondicionListDTO implements Serializable{
	
	private static final long serialVersionUID = -4922599109841693508L;

	private Long id;
	private String descripcion;
	private Long idPadre;
	
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
	public Long getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}
	
}
