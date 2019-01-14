package com.dospe.gestionbecarios.controller.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.dospe.gestionbecarios.persistence.domain.Sexo;
import com.dospe.gestionbecarios.util.JsonDateDeserializer;
import com.dospe.gestionbecarios.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class BecarioDTO implements Serializable {

	private static final long serialVersionUID = -3101669372822728174L;

	private Long id;
	private String dni;
	@NotNull(message = "<span>Nombre: </span> Es requerido.")
	private String nombres;
	@NotNull(message = "<span>Apellidos: </span> Es requerido.")
	private String apellidos;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date fechaNacimiento;
	private Integer edad;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String numeroExpediente;
	private Long idAsignacion;
	private Long idAsesor;
	private Long idCarrera;
	private Long idSedeEstudio;
	private Long idIes;
	private Long idBeca;
	private Long idEstado;
	private Long idCondicion;
	private String resolucionAdjudicacion;
	@JsonDeserialize(using = JsonDateDeserializer.class)
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date resolucionAdjudicacionFecha;
	private String contacto;
	private String contactoTelefono;
	private String telefonos;
	@Email(message = "<span>Correo Pronabec: </span> Ingrese un correo valido")
	private String correoPronabec;
	@Email(message = "<span>Correo Personal: </span> Ingrese un correo valido")
	private String correoPersonal;
	private String direccion;
	private String regionProcedencia;
	private String provinciaProcedencia;
	private String distritoProcedencia;
	private String documentoCulminacion;
	private String resolucionPerdidaBeca;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getContactoTelefono() {
		return contactoTelefono;
	}

	public void setContactoTelefono(String contactoTelefono) {
		this.contactoTelefono = contactoTelefono;
	}

	public String getDocumentoCulminacion() {
		return documentoCulminacion;
	}

	public void setDocumentoCulminacion(String documentoCulminacion) {
		this.documentoCulminacion = documentoCulminacion;
	}

	public String getResolucionPerdidaBeca() {
		return resolucionPerdidaBeca;
	}

	public void setResolucionPerdidaBeca(String resolucionPerdidaBeca) {
		this.resolucionPerdidaBeca = resolucionPerdidaBeca;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Long getIdAsesor() {
		return idAsesor;
	}

	public void setIdAsesor(Long idAsesor) {
		this.idAsesor = idAsesor;
	}

	public Long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Long idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Long getIdSedeEstudio() {
		return idSedeEstudio;
	}

	public void setIdSedeEstudio(Long idSedeEstudio) {
		this.idSedeEstudio = idSedeEstudio;
	}

	public Long getIdIes() {
		return idIes;
	}

	public void setIdIes(Long idIes) {
		this.idIes = idIes;
	}

	public Long getIdBeca() {
		return idBeca;
	}

	public void setIdBeca(Long idBeca) {
		this.idBeca = idBeca;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Becario[").append("\n");
		sb.append("id:").append(id).append(",").append("\n");
		sb.append("asesor:").append(idAsesor).append(",").append("\n");
		sb.append("beca:").append(idBeca).append(",").append("\n");
		sb.append("carrera:").append(idCarrera).append(",").append("\n");
		sb.append("ies:").append(idIes).append(",").append("\n");
		sb.append("sede:").append(idSedeEstudio).append(",").append("\n");
		sb.append("expediente:").append(numeroExpediente).append(",").append("\n");
		sb.append("res-adj:").append(resolucionAdjudicacion).append(",").append("\n");
		sb.append("fec-res-adj:").append(resolucionAdjudicacionFecha).append(",").append("\n");
		sb.append("r-proc:").append(regionProcedencia).append(",").append("\n");
		sb.append("p-proc:").append(provinciaProcedencia).append(",").append("\n");
		sb.append("d-proc:").append(distritoProcedencia).append(",").append("\n");
		sb.append("dni:").append(dni).append(",").append("\n");
		sb.append("nombre:").append(nombres).append(",").append("\n");
		sb.append("apellidos:").append(apellidos).append(",").append("\n");
		sb.append("f-nac:").append(fechaNacimiento).append(",").append("\n");
		sb.append("edad:").append(edad).append(",").append("\n");
		sb.append("sexo:").append(sexo).append(",").append("\n");
		sb.append("correo-p:").append(correoPersonal).append(",").append("\n");
		sb.append("telef:").append(telefonos).append(",").append("\n");
		sb.append("direccion:").append(direccion).append(",").append("\n");
		sb.append("contacto:").append(contacto).append(",").append("\n");
		sb.append("contacto-t:").append(contactoTelefono).append(",").append("\n");
		sb.append("estado:").append(idEstado).append(",").append("\n");
		sb.append("condicion:").append(idCondicion).append(",").append("\n");
		sb.append("doc-culm:").append(documentoCulminacion).append(",").append("\n");
		sb.append("res-perd-beca:").append(resolucionPerdidaBeca).append(",").append("\n");
		sb.append("obs:").append(observaciones).append("\n");
		sb.append("asignacion").append(idAsignacion);
		sb.append("]");
		
		return sb.toString();
	}
}
