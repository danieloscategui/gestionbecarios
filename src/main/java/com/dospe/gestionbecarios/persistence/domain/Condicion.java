package com.dospe.gestionbecarios.persistence.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_condicion")
public class Condicion implements Serializable {
	
	private static final long serialVersionUID = 1609230783974095097L;

	@Id
	@SequenceGenerator(name="condicionSequence", sequenceName="gb_condicion_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="condicionSequence")
	@Column(name="id_condicion")
	private Long idCondicion;
	
	@Column
	private String descripcion;
	
	@JoinColumn(name="id_estado", referencedColumnName="id_estado")
	@ManyToOne(optional=false)
	private Estado estado;
	
	@Column(name="id_sub_condicion")
	private Long idSubCondicion;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="condicion", fetch=FetchType.LAZY)
	private List<Becario> becarios = new ArrayList<Becario>();

	public Condicion() {
	}
	
	public Condicion(String descripcion, Estado estado, Long idSubCondicion) {
		this.descripcion = descripcion;
		this.estado = estado;
		this.idSubCondicion = idSubCondicion;
	}

	public Long getIdCondicion() {
		return idCondicion;
	}

	public void setIdCondicion(Long idCondicion) {
		this.idCondicion = idCondicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getIdSubCondicion() {
		return idSubCondicion;
	}

	public void setIdSubCondicion(Long idSubCondicion) {
		this.idSubCondicion = idSubCondicion;
	}
	
	public List<Becario> getBecarios() {
		return becarios;
	}

	public void setBecarios(List<Becario> becarios) {
		this.becarios = becarios;
	}

	public boolean isNew(){
		return (this.idCondicion == null);
	}
}
