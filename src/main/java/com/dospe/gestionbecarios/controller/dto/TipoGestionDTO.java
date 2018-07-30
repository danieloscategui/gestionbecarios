package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TipoGestionDTO implements Serializable{
	private static final long serialVersionUID = 9210175830696111229L;

	private Long id;
	
	@NotNull(message="<span>Descripción: </span> Es requerido")
	private String descripcion;
	
	public TipoGestionDTO() {
		super();
	}
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
