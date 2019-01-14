package com.dospe.gestionbecarios.transactional.service;

import java.util.List;

import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;

public interface SedeEstudioService extends CrudService<SedeEstudio, Long> {
	public List<SedeEstudio> findAllByIes(Long idIes);
}
