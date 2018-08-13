package com.dospe.gestionbecarios.persistence.domain;

import java.io.Serializable;
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

@Entity
@Table(name="gb_asignacion")
public class Asignacion implements Serializable {

	private static final long serialVersionUID = -7640645316340776354L;

	@Id
	@SequenceGenerator(name="asignacion_sequence", sequenceName="gb_asignacion_seq", allocationSize=20)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="asignacion_sequence")
	@Column(name="id_asignacion")
	private Long idAsignacion;
	
	@Column(name="id_carrera")
	private Long idCarrera;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_carrera", referencedColumnName="id_carrera", insertable=false, nullable=false, updatable=false)
	private Carrera carrera;
	
	@Column(name="id_sede_estudio")
	private Long idSedeEstudio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_sede_estudio", referencedColumnName="id_sede_estudio", insertable=false, nullable=false, updatable=false)
	private SedeEstudio sedeEstudio;
	
	@Column(name="id_asesor")
	private Long idAsesor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_asesor", referencedColumnName="id_asesor", insertable=false, nullable=false, updatable=false)
	private Asesor asesor;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="asignacion", fetch=FetchType.LAZY)
	private List<Becario> becarios;
	
	public Long getIdAsignacion() {
		return idAsignacion;
	}
	
	public void setIdAsignacion(Long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	
	public Long getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Long idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Carrera getCarrera() {
		return carrera;
	}
	
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public Long getIdSedeEstudio() {
		return idSedeEstudio;
	}

	public void setIdSedeEstudio(Long idSedeEstudio) {
		this.idSedeEstudio = idSedeEstudio;
	}

	public SedeEstudio getSedeEstudio() {
		return sedeEstudio;
	}
	
	public void setSedeEstudio(SedeEstudio sedeEstudio) {
		this.sedeEstudio = sedeEstudio;
	}
	
	public Long getIdAsesor() {
		return idAsesor;
	}

	public void setIdAsesor(Long idAsesor) {
		this.idAsesor = idAsesor;
	}

	public Asesor getAsesor() {
		return asesor;
	}
	
	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	
	public List<Becario> getBecarios() {
		return becarios;
	}

	public void setBecarios(List<Becario> becarios) {
		this.becarios = becarios;
	}

	public boolean isNew(){
		return (this.idAsignacion == null);
	}
	
}
