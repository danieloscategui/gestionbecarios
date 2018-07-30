package com.dospe.gestionbecarios.persistence.domain;

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
	private Long id;
	
	@Column
	private String descripcion;
	
	@Column(name="semestre_egreso")
	private String semestreEgreso;
	
	@Column(name="id_beca")
	private Long idBeca;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_beca", referencedColumnName="id_beca", nullable = false, insertable = false, updatable = false)
	private Beca beca;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="carrera", fetch=FetchType.LAZY)
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
	
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

	public Long getIdBeca() {
		return idBeca;
	}

	public void setIdBeca(Long idBeca) {
		this.idBeca = idBeca;
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
		return (this.id == null);
	}
}
