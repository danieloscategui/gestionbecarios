package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CarreraDTO implements Serializable {

	private static final long serialVersionUID = 4550123698058719431L;
	
	private Long id;

	@NotNull(message = "<span>Descripción: </span> Es requerido")
	private String descripcion;
	
	@NotNull(message = "<span>Semestre Egreso: </span> Es requerido")
	private String semestreEgreso;

	@NotNull(message = "<span>Beca: </span> Es requerido")
	private Long idBeca;
	
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

	public String getSemestreEgreso() {
		return semestreEgreso;
	}

	public void setSemestreEgreso(String semestreEgreso) {
		this.semestreEgreso = semestreEgreso;
	}

	public Long getIdBeca() {
		return idBeca;
	}

	public void setIdBeca(Long idBeca) {
		this.idBeca = idBeca;
	}
	
	
}
