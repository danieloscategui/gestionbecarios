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
@Table(name="gb_asesor")
public class Asesor implements Serializable{

	private static final long serialVersionUID = 1694000780957676471L;

	@Id
	@SequenceGenerator(name="asesorSequence", sequenceName="gb_asesor_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="asesorSequence")
	@Column(name="id_asesor")
	private Long idAsesor;
	
	@Column(name="nombre")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="asesor", fetch=FetchType.LAZY)
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
	
	public Long getIdAsesor() {
		return idAsesor;
	}
	public void setIdAsesor(Long idAsesor) {
		this.idAsesor = idAsesor;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Asignacion> getAsignaciones() {
		return asignaciones;
	}
	public void setAsignaciones(List<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}
	public boolean isNew(){
		return (this.idAsesor == null);
	}
	
}
