package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;
import java.util.Date;

import com.dospe.gestionbecarios.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BecaListDTO implements Serializable {

	private static final long serialVersionUID = 7199863298950977350L;

	private Long id;
	
	private String convocatoria;
	
	private String modalidad;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getBecaName() {
		return this.convocatoria + " - " + this.modalidad;
	}

}
