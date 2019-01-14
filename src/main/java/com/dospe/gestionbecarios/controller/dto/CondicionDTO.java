package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class CondicionDTO implements Serializable{
	
	private static final long serialVersionUID = -4922599109841693508L;

	private Long id;
	private String descripcion;
	private Long idEstado;
	private Long idSubCondicion;
	
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
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public Long getIdSubCondicion() {
		return idSubCondicion;
	}
	public void setIdSubCondicion(Long idSubCondicion) {
		this.idSubCondicion = idSubCondicion;
	}
	
}
