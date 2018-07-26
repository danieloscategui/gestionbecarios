package com.dospe.gestionbecarios.persistence.model;

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
@Table(name="gb_tipo_ies")
public class TipoIes implements Serializable{
	
	private static final long serialVersionUID = -5099610594669239173L;

	@Id
	@SequenceGenerator(name="tipoIesSequence", sequenceName="gb_tipo_ies_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tipoIesSequence")
	@Column(name="id_tipo_ies")
	private Long idTipoIes;
	
	@Column
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="tipoIes", fetch=FetchType.LAZY)
	private List<Ies> ies = new ArrayList<Ies>();
	
	public Long getIdTipoIes() {
		return idTipoIes;
	}

	public void setIdTipoIes(Long idTipoIes) {
		this.idTipoIes = idTipoIes;
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
		return (this.idTipoIes == null);
	}
	
}
