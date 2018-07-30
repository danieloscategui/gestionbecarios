package com.dospe.gestionbecarios.transactional.service;

import com.dospe.gestionbecarios.persistence.domain.TipoIes;

public interface TipoIesService extends CrudService<TipoIes, Long> {
	public TipoIes findByDescripcion(String descripcion);
}
