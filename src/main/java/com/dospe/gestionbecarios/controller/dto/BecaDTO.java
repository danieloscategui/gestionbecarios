package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.dospe.gestionbecarios.util.JsonDateDeserializer;
import com.dospe.gestionbecarios.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BecaDTO implements Serializable {
	private static final long serialVersionUID = 8922074438345437232L;

	private Long id;
	
	@NotNull(message = "<span>Convocatoria: </span> Es requerido.")
	private String convocatoria;
	
	@NotNull(message = "<span>Modalidad: </span> Es requerido.")
	private String modalidad;
	
	@NotNull(message = "<span>Fecha Inicio: </span> Es requerido.")
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date inicio;
	
	@NotNull(message = "<span>Fecha Termino: </span> Es requerido.")
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date termino;

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

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

}
