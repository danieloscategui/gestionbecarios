package com.dospe.gestionbecarios.transactional.service;

import java.util.List;

import com.dospe.gestionbecarios.persistence.domain.Carrera;

public interface CarreraService extends CrudService<Carrera, Long>{
	public Carrera findByDescripcion(Long idBeca, String descripcion);
	public List<Carrera> findAllByBeca(Long idBeca);
}
