package com.dospe.gestionbecarios.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_beca")
public class Beca implements Serializable{

	private static final long serialVersionUID = -8532256700193379586L;

	@Id
	@SequenceGenerator(name="becaSequence", sequenceName="gb_beca_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="becaSequence")
	@Column(name="id_beca")
	private Long idBeca;
	
	@Column
	private String convocatoria;

	@Column
	private String modalidad;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date inicio;

	@Column
	@Temporal(TemporalType.DATE)
	private Date termino;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "beca", fetch=FetchType.LAZY)
	private List<Carrera> carreras = new ArrayList<Carrera>();
	
	public Long getIdBeca() {
		return idBeca;
	}

	public void setIdBeca(Long idBeca) {
		this.idBeca = idBeca;
	}

	public String getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(String convocatoria) {
		this.convocatoria = convocatoria;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	
	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public boolean isNew(){
		return (this.idBeca == null);
	}
	
	public String getShortName(){
		StringBuilder sb = new StringBuilder();
		sb.append(convocatoria).append(" - ").append(modalidad);
		return sb.toString();
	}
}
