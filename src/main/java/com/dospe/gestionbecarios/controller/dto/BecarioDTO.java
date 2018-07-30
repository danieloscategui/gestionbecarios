package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.dospe.gestionbecarios.persistence.domain.Sexo;
import com.dospe.gestionbecarios.util.JsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class BecarioDTO implements Serializable {

	private static final long serialVersionUID = -3101669372822728174L;

	private Long id;
	@NotNull(message = "<span>Nombre: </span> Es requerido.")
	private String nombres;
	@NotNull(message = "<span>Apellidos: </span> Es requerido.")
	private String apellidos;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date fechaNacimiento;
	private Integer edad;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String numeroExpediente;
	private Long idAsignacion;
	private Long idEstado;
	private Long idCondicion;
	private String resolucionAdjudicacion;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	private Date resolucionAdjudicacionFecha;
	private String representante;
	private String representanteDni;
	private String telefonos;
	@Email(message = "<span>Correo Pronabec: </span> Ingrese un correo valido")
	private String correoPronabec;
	@Email(message = "<span>Correo Personal: </span> Ingrese un correo valido")
	private String correoPersonal;
	private String direccion;
	private String regionProcedencia;
	private String provinciaProcedencia;
	private String distritoProcedencia;
	private String regionPostulacion;
	private String provinciaPostulacion;
	private String distritoPostulacion;
	private String observaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}
	
	public Long getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(Long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(Long idCondicion) {
		this.idCondicion = idCondicion;
	}

	public String getResolucionAdjudicacion() {
		return resolucionAdjudicacion;
	}

	public void setResolucionAdjudicacion(String resolucionAdjudicacion) {
		this.resolucionAdjudicacion = resolucionAdjudicacion;
	}

	public Date getResolucionAdjudicacionFecha() {
		return resolucionAdjudicacionFecha;
	}

	public void setResolucionAdjudicacionFecha(Date resolucionAdjudicacionFecha) {
		this.resolucionAdjudicacionFecha = resolucionAdjudicacionFecha;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getRepresentanteDni() {
		return representanteDni;
	}

	public void setRepresentanteDni(String representanteDni) {
		this.representanteDni = representanteDni;
	}

	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	public String getCorreoPronabec() {
		return correoPronabec;
	}

	public void setCorreoPronabec(String correoPronabec) {
		this.correoPronabec = correoPronabec;
	}

	public String getCorreoPersonal() {
		return correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRegionProcedencia() {
		return regionProcedencia;
	}

	public void setRegionProcedencia(String regionProcedencia) {
		this.regionProcedencia = regionProcedencia;
	}

	public String getProvinciaProcedencia() {
		return provinciaProcedencia;
	}

	public void setProvinciaProcedencia(String provinciaProcedencia) {
		this.provinciaProcedencia = provinciaProcedencia;
	}

	public String getDistritoProcedencia() {
		return distritoProcedencia;
	}

	public void setDistritoProcedencia(String distritoProcedencia) {
		this.distritoProcedencia = distritoProcedencia;
	}

	public String getRegionPostulacion() {
		return regionPostulacion;
	}

	public void setRegionPostulacion(String regionPostulacion) {
		this.regionPostulacion = regionPostulacion;
	}

	public String getProvinciaPostulacion() {
		return provinciaPostulacion;
	}

	public void setProvinciaPostulacion(String provinciaPostulacion) {
		this.provinciaPostulacion = provinciaPostulacion;
	}

	public String getDistritoPostulacion() {
		return distritoPostulacion;
	}

	public void setDistritoPostulacion(String distritoPostulacion) {
		this.distritoPostulacion = distritoPostulacion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
