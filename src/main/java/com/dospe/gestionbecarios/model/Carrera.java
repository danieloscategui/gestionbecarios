package com.dospe.gestionbecarios.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_carrera")
public class Carrera implements Serializable{
	
	private static final long serialVersionUID = 8774107940560900477L;

	@Id
	@SequenceGenerator(name="carreraSequence", sequenceName="gb_carrera_seq", allocationSize=20)
	@Column(name="id_carrera")
	private Long idCarrera;
	
	@Column
	private String descripcion;
	
	@Column(name="semestre_egreso")
	private String semestreEgreso;
	
	@JoinColumn(name="id_beca", referencedColumnName="id_beca")
	@ManyToOne(optional=false)
	private Beca beca;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="carrera", fetch=FetchType.LAZY)
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
	
	public Long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Long idCarrera) {
		this.idCarrera = idCarrera;
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

	public Beca getBeca() {
		return beca;
	}

	public void setBeca(Beca beca) {
		this.beca = beca;
	}
	
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public boolean isNew(){
		return (this.idCarrera == null);
	}
}
