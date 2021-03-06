package com.dospe.gestionbecarios.model;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_estado")
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 5465886665038812069L;

	@Id
	@SequenceGenerator(name="estadoSequence", sequenceName="gb_estado_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estadoSequence")
	@Column(name="id_estado")
	private Long idEstado;
	
	@Column
	private String descripcion;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="estado", fetch=FetchType.LAZY)
	private List<Becario> becarios = new ArrayList<Becario>();

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Becario> getBecarios() {
		return becarios;
	}

	public void setBecarios(List<Becario> becarios) {
		this.becarios = becarios;
	}

	public boolean isNew(){
		return (this.idEstado == null);
	}
}
