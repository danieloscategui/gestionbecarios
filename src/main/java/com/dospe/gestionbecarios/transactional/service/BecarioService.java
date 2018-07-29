package com.dospe.gestionbecarios.transactional.service;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.persistence.domain.BecarioView;


public interface BecarioService extends CrudService<Becario, Long> {
	public Collection<BecarioView> findBecariosPorBeca(Long idBeca);
	public Collection<Becario> findByDNI(String DNI);
}
