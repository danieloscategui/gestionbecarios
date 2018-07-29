package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AsesorAddDTO implements Serializable {

	private static final long serialVersionUID = -3425206298355399647L;

	private Long id;
	
	@NotNull(message = "<span>Nombre:</span> Es requerido.")
	@NotBlank(message = "<span>Nombre:</span> Es requerido.")
	private String nombre;

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

}
