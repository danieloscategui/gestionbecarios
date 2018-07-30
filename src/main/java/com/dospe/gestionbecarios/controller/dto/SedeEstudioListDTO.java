package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class SedeEstudioListDTO implements Serializable {
	
	private static final long serialVersionUID = -1682879310083541338L;

	private Long id;
	
	private String region;
	
	private String sede;
	
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
	
}
