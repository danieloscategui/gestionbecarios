package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class EstadoDTO implements Serializable {
	
	private static final long serialVersionUID = -3442199441869691425L;

	private Long idEstado;
	private String descripcion;
	
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
