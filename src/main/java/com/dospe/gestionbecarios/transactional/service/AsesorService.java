package com.dospe.gestionbecarios.transactional.service;

import com.dospe.gestionbecarios.persistence.domain.Asesor;

public interface AsesorService extends CrudService<Asesor, Long>{
	public boolean existsByNombreIgnoreCase(String nombre);
}
