package com.dospe.gestionbecarios.transactional.service;

import com.dospe.gestionbecarios.persistence.domain.TipoGestion;

public interface TipoGestionService extends CrudService<TipoGestion, Long> {
	public boolean existsByDescripcionIgnoreCase(String descripcion);
}
