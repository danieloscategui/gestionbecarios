package com.dospe.gestionbecarios.transactional.service;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.model.Becario;
import com.dospe.gestionbecarios.persistence.model.BecarioView;


public interface BecarioService extends CrudService<Becario, Long> {
	public Collection<BecarioView> findBecariosPorBeca(Long idBeca);
	public Collection<Becario> findByDNI(String DNI);
}
