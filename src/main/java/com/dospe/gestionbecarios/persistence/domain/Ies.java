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
@Table(name="gb_ies")
public class Ies implements Serializable{

	private static final long serialVersionUID = -5266616715694626963L;

	@Id
	@SequenceGenerator(name="iesSequence", sequenceName="gb_ies_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="iesSequence")
	@Column(name="id_ies")
	private Long id;
	
	@Column
	@ColumnTransformer(write="upper(?)")
	private String nombre;
	
	@Column(name="id_tipo_ies")
	private Long idTipoIes;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_ies", referencedColumnName="id_tipo_ies", nullable = false, insertable = false, updatable = false)
	private TipoIes tipoIes;
	
	@Column(name="id_tipo_gestion")
	private Long idTipoGestion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_gestion", referencedColumnName="id_tipo_gestion", nullable = false, insertable = false, updatable = false)
	private TipoGestion tipoGestion;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="ies", fetch=FetchType.LAZY)
	private List<SedeEstudio> sedes = new ArrayList<SedeEstudio>();
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdTipoGestion() {
		return idTipoGestion;
	}
	public void setIdTipoGestion(Long idTipoGestion) {
		this.idTipoGestion = idTipoGestion;
	}
	public TipoGestion getTipoGestion() {
		return tipoGestion;
	}
	public void setTipoGestion(TipoGestion tipoGestion) {
		this.tipoGestion = tipoGestion;
	}
	public Long getIdTipoIes() {
		return idTipoIes;
	}
	public void setIdTipoIes(Long idTipoIes) {
		this.idTipoIes = idTipoIes;
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
		return (this.id == null);
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
	
}
