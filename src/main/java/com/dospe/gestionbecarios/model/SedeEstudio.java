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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_sede_estudio")
public class SedeEstudio implements Serializable {

	private static final long serialVersionUID = -3178972070747791038L;

	@Id
	@SequenceGenerator(name="sedeEstudioSequence", sequenceName="gb_sede_estudio_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sedeEstudioSequence")
	@Column(name="id_sede_estudio")
	private Long idSedeEstudio;
	
	@Column
	private String region;
	
	@Column
	private String sede;
	
	@JoinColumn(name="id_ies", referencedColumnName="id_ies")
	@ManyToOne(optional=false)
	private Ies ies;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sedeEstudio", fetch=FetchType.LAZY)
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
	
	public Long getIdSedeEstudio() {
		return idSedeEstudio;
	}
	
	public void setIdSedeEstudio(Long idSedeEstudio) {
		this.idSedeEstudio = idSedeEstudio;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getSede() {
		return sede;
	}
	
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	public Ies getIes() {
		return ies;
	}
	
	public void setIes(Ies ies) {
		this.ies = ies;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public boolean isNew(){
		return (this.idSedeEstudio == null);
	}
}
