package com.dospe.gestionbecarios.transactional.service;

import java.util.List;

import com.dospe.gestionbecarios.persistence.domain.Condicion;

public interface CondicionService extends CrudService<Condicion, Long> {
	public List<Condicion> findAllByEstado(Long idEstado);
	public List<Condicion> findAllByEstadoAndCondicion(Long idEstado, Long idCondicion);
	public boolean existsByDescripcionIgnoreCaseAndIdEstado(String nombre, Long idEstado);
}
