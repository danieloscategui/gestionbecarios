package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class IesDTO implements Serializable{
	private static final long serialVersionUID = 4085484744188463655L;

	private Long id;
	
	@NotNull(message = "<span>Nombre:</span> Es requerido.")
	private String nombre;
	
	@NotNull(message = "<span>Tipo de Gestión:</span> Es requerido")
	private Long idTipoGestion;
	
	@NotNull(message = "<span>Tipo de IES:</span> Es requerido")
	private Long idTipoIes;
	
	private String contacto;
	private String telefono;
	private String correo;

	public IesDTO() {
		super();
	}
	
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
	public Long getIdTipoGestion() {
		return idTipoGestion;
	}
	public void setIdTipoGestion(Long idTipoGestion) {
		this.idTipoGestion = idTipoGestion;
	}
	public Long getIdTipoIes() {
		return idTipoIes;
	}
	public void setIdTipoIes(Long idTipoIes) {
		this.idTipoIes = idTipoIes;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
