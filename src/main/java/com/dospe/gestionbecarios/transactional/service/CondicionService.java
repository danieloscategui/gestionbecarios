package com.dospe.gestionbecarios.transactional.service;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.model.Condicion;

public interface CondicionService extends CrudService<Condicion, Long> {
	public Collection<Condicion> findAllByEstado(Long idEstado);
	public Collection<Condicion> findAllByCondicion(Long idCondicion);
}
