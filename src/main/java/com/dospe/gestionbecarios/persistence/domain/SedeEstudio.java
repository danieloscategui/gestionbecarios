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

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="gb_sede_estudio")
public class SedeEstudio implements Serializable {

	private static final long serialVersionUID = -3178972070747791038L;

	@Id
	@SequenceGenerator(name="sedeEstudioSequence", sequenceName="gb_sede_estudio_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sedeEstudioSequence")
	@Column(name="id_sede_estudio")
	private Long id;
	
	@Column
	@ColumnTransformer(write="upper(?)")
	private String region;
	
	@Column
	@ColumnTransformer(write="upper(?)")
	private String sede;
	
	@Column(name="id_ies")
	private Long idIes;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ies", referencedColumnName="id_ies", nullable = false, insertable = false, updatable = false)
	private Ies ies;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="sedeEstudio", fetch=FetchType.LAZY)
	private List<Asignacion> asignaciones = new ArrayList<Asignacion>();
	
	@Column
	@ColumnTransformer(write="upper(?)")
	private String contacto;
	@Column
	private String telefono;
	@Column
	@ColumnTransformer(write="upper(?)")
	private String correo;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public Long getIdIes() {
		return idIes;
	}

	public void setIdIes(Long idIes) {
		this.idIes = idIes;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SedeEstudio: ").append("\n");
		sb.append("ID[").append(this.id).append("], ");
		sb.append("REGION[").append(this.region).append("], ");
		sb.append("SEDE[").append(this.sede).append("], ");
		sb.append("ID_IES[").append(this.idIes).append("], ");
		sb.append("CONTACTO[").append(this.contacto).append("], ");
		sb.append("TELEFONO[").append(this.telefono).append("], ");
		sb.append("CORREO[").append(this.correo).append("], ");
		return sb.toString();
	}
}
