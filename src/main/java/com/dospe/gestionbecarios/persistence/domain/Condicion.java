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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_condicion")
public class Condicion implements Serializable {
	
	private static final long serialVersionUID = 1609230783974095097L;

	@Id
	@SequenceGenerator(name="condicionSequence", sequenceName="gb_condicion_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="condicionSequence")
	@Column(name="id_condicion")
	private Long id;
	
	@Column
	private String descripcion;
	
	@Column(name="id_estado")
	private Long idEstado;
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_estado", referencedColumnName="id_estado", nullable=false, insertable=false, updatable=false)
	private Estado estado;
	*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name="id_padre", referencedColumnName="id_condicion", nullable = true, insertable = false, updatable = false)
	private Condicion condicionPadre;

	@JsonIgnore
	@OneToMany(mappedBy="condicionPadre", fetch=FetchType.LAZY)
	private List<Condicion> subCondiciones = new ArrayList<Condicion>();
	
	@Column(name="id_padre")
	private Long idPadre;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="condicion", fetch=FetchType.LAZY)
	private List<Becario> becarios = new ArrayList<Becario>();

	public Condicion() {
	}
	
	public Condicion(String descripcion, Estado estado, Long idPadre) {
		this.descripcion = descripcion;
//		this.estado = estado;
		this.idPadre = idPadre;
	}

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

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
/*
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}*/

	public Long getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(Long idPadre) {
		this.idPadre = idPadre;
	}
	
	public List<Becario> getBecarios() {
		return becarios;
	}

	public void setBecarios(List<Becario> becarios) {
		this.becarios = becarios;
	}

	public Condicion getCondicionPadre() {
		return condicionPadre;
	}

	public void setCondicionPadre(Condicion condicionPadre) {
		this.condicionPadre = condicionPadre;
	}

	public List<Condicion> getSubCondiciones() {
		return subCondiciones;
	}

	public void setSubCondiciones(List<Condicion> subCondiciones) {
		this.subCondiciones = subCondiciones;
	}
	
}
