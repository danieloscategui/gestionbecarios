package com.dospe.gestionbecarios.service.base;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<T extends Serializable> {
	public T findOne(Long id);
	public List<T> findAll();
	public List<T> findAllPaginated(Integer offset, Integer maxResults);
	public Long count();
	public String saveOrUpdate(T entity);
	public void delete(T entity);
	public void deleteById(Long id);
}
