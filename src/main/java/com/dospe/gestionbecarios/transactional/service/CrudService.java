package com.dospe.gestionbecarios.transactional.service;

import java.util.Collection;

import org.springframework.data.domain.Page;

public interface CrudService<Entity, TypeId> {
	public Collection<Entity> findAll();
	public void save(Entity entity);
	public Entity findById(TypeId id);
	public void remove(TypeId id);
	public Page<Entity> findPaginated(int page, int size, String orden, String campo);
}
