package com.dospe.gestionbecarios.transactional.service;

import com.dospe.gestionbecarios.persistence.domain.Ies;

public interface IesService extends CrudService<Ies, Long> {
	public Ies findByNombre(String nombre);
}
