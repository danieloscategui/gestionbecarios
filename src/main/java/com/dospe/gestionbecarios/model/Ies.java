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
@Table(name="gb_ies")
public class Ies implements Serializable{

	private static final long serialVersionUID = -5266616715694626963L;

	@Id
	@SequenceGenerator(name="iesSequence", sequenceName="gb_ies_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="iesSequence")
	@Column(name="id_ies")
	private Long idIes;
	
	@Column
	private String nombre;
	
	@JoinColumn(name="id_tipo_ies", referencedColumnName="id_tipo_ies")
	@ManyToOne(optional=false)
	private TipoIes tipoIes;
	
	@JoinColumn(name="id_tipo_gestion", referencedColumnName="id_tipo_gestion")
	@ManyToOne(optional=false)
	private TipoGestion tipoGestion;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="ies", fetch=FetchType.LAZY)
	private List<SedeEstudio> sedes = new ArrayList<SedeEstudio>();
	
	public Long getIdIes() {
		return idIes;
	}
	public void setIdIes(Long idIes) {
		this.idIes = idIes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoGestion getTipoGestion() {
		return tipoGestion;
	}
	public void setTipoGestion(TipoGestion tipoGestion) {
		this.tipoGestion = tipoGestion;
	}
	public TipoIes getTipoIes() {
		return tipoIes;
	}
	public void setTipoIes(TipoIes tipoIes) {
		this.tipoIes = tipoIes;
	}
	
	public List<SedeEstudio> getSedes() {
		return sedes;
	}
	public void setSedes(List<SedeEstudio> sedes) {
		this.sedes = sedes;
	}
	public boolean isNew(){
		return (this.idIes == null);
	}
}
