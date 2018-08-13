package com.dospe.gestionbecarios.persistence.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="gb_becario")
public class Becario implements Serializable {

	private static final long serialVersionUID = 8308709621688477320L;

	@Id
	@SequenceGenerator(name="becarioSequence", sequenceName="gb_becario_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="becarioSequence")
	@Column(name="id_becario")
	private Long id;
	
	@Column
	private String dni;

	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	

	@Column(name="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column
	private Integer edad;

	@Enumerated(EnumType.STRING)
	@Column
	private Sexo sexo;
	
	@Column(name="id_asignacion")
	private Long idAsignacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_asignacion", referencedColumnName="id_asignacion", insertable=false, nullable=false, updatable=false)
	private Asignacion asignacion;
	
	@Column(name="numero_expediente")
	private String numeroExpediente;

	@Column(name="id_estado")
	private Long idEstado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estado", referencedColumnName="id_estado", insertable=false, nullable=false, updatable=false)
	private Estado estado;
	
	@Column(name="id_condicion")
	private Long idCondicion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_condicion", referencedColumnName="id_condicion", insertable=false, nullable=false, updatable=false)
	private Condicion condicion;
	
	@Column(name="resolucion_adjudicacion")
	private String resolucionAdjudicacion;

	@Column(name="resolucion_adjudicacion_fecha")
	@Temporal(TemporalType.DATE)
	private Date resolucionAdjudicacionFecha;

	@Column(name="representante")
	private String representante;
	
	@Column(name="representante_dni")
	private String representanteDni;
	
	@Column
	private String telefonos;
	
	@Column(name="correo_pronabec")
	private String correoPronabec;
	
	@Column(name="correo_personal")
	private String correoPersonal;
	
	@Column
	private String direccion;
	
	@Column(name="region_procedencia")
	private String regionProcedencia;
	
	@Column(name="provincia_procedencia")
	private String provinciaProcedencia;
	
	@Column(name="distrito_procedencia")
	private String distritoProcedencia;
	
	@Column(name="region_postulacion")
	private String regionPostulacion;
	
	@Column(name="provincia_postulacion")
	private String provinciaPostulacion;
	
	@Column(name="distrito_postulacion")
	private String distritoPostulacion;
	
	@Column(name="observaciones")
	private String observaciones;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
	public Long getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(Long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Asignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String numeroExpediente) {
		this.numeroExpediente = numeroExpediente;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(Long idCondicion) {
		this.idCondicion = idCondicion;
	}

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
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

	public boolean isNew(){
		return (this.id == null);
	}
	
	public String getFullName(){
		StringBuilder sb = new StringBuilder();
		sb.append(nombres).append(" ").append(apellidos);
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID[").append(id).append("], ");
		sb.append("Full Name[").append(getFullName()).append("], ");
		sb.append("DNI[").append(dni).append("], ");
		sb.append("Estado[").append(estado.getDescripcion()).append("]");
		return sb.toString();
	}
}
