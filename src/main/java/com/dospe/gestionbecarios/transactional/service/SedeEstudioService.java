package com.dospe.gestionbecarios.transactional.service;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;

public interface SedeEstudioService extends CrudService<SedeEstudio, Long> {
	public Collection<SedeEstudio> findAllByIes(Long idIes);
}
