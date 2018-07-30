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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_tipo_gestion")
public class TipoGestion implements Serializable {

	private static final long serialVersionUID = -6154661838654283393L;

	@Id
	@SequenceGenerator(name="tipoGestionSequence", sequenceName="gb_tipo_gestion_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipoGestionSequence")
	@Column(name="id_tipo_gestion")
	private Long id;
	
	@Column
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="tipoGestion", fetch=FetchType.LAZY)
	private List<Ies> ies = new ArrayList<Ies>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id= id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Ies> getIes() {
		return ies;
	}

	public void setIes(List<Ies> ies) {
		this.ies = ies;
	}

	public boolean isNew(){
		return (this.id == null);
	}
}
