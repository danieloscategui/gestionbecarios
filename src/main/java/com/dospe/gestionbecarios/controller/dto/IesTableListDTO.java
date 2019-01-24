package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;
import java.util.List;

public class IesTableListDTO implements Serializable{
	private static final long serialVersionUID = 4085484744188463655L;

	private Long id;
	private String nombre;
	private String tipoGestion;
	private String tipoIes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoGestion() {
		return tipoGestion;
	}
	public void setTipoGestion(String tipoGestion) {
		this.tipoGestion = tipoGestion;
	}
	public String getTipoIes() {
		return tipoIes;
	}
	public void setTipoIes(String tipoIes) {
		this.tipoIes = tipoIes;
	}
	
}
