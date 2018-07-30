package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class SedeEstudioDTO implements Serializable {
	
	private static final long serialVersionUID = -308121703301796467L;

	private Long id;
	
	@NotNull(message="<span>Región: </span> Es requerido.")
	private String region;
	
	@NotNull(message="<span>Región: </span> Es requerido.")
	private String sede;
	
	@NotNull(message="<span>IES: </span> Es requerido.")
	private Long idIes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public Long getIdIes() {
		return idIes;
	}
	public void setIdIes(Long idIes) {
		this.idIes = idIes;
	}
	
}
