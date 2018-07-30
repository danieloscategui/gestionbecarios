package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class TipoIesDTO implements Serializable {
	private static final long serialVersionUID = -4197281183701538113L;
	private Long id;
	@NotNull(message = "<span>Descripción: </span> Es requerida")
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
