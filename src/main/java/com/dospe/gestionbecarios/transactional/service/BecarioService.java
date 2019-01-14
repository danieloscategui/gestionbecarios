package com.dospe.gestionbecarios.transactional.service;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.dospe.gestionbecarios.persistence.domain.Asignacion;
import com.dospe.gestionbecarios.persistence.domain.Becario;


public interface BecarioService extends CrudService<Becario, Long> {
	Collection<Becario> findBecariosPorBeca(Long idBeca);
	Page<Becario> findAllByBeca(Long idBeca, int page, int size);
	Page<Becario> findAllByBecaAndDni(Long idBeca, String dni, int page, int size);
	void save(Becario becario, Asignacion asignacion);
}
