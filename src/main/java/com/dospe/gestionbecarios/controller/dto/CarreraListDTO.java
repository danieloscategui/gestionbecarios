package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

public class CarreraListDTO implements Serializable{

	private static final long serialVersionUID = -8260344199708183208L;
	private Long id;
	private String descripcion;
	private String semestreEgreso;
	private String beca;
	
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
	public String getBeca() {
		return beca;
	}
	public void setBeca(String beca) {
		this.beca = beca;
	}
	
}
