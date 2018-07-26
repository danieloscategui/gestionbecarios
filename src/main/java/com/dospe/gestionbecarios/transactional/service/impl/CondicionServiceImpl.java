package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.model.Condicion;
import com.dospe.gestionbecarios.repository.CondicionRepository;
import com.dospe.gestionbecarios.service.CondicionService;

@Service
public class CondicionServiceImpl implements CondicionService {

	@Autowired
	private CondicionRepository condicionDAO;

	public void setCondicionDAO(CondicionRepository condicionDAO) {
		this.condicionDAO = condicionDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Condicion findOne(Long id) {
		return condicionDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAll() {
		return condicionDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAllPaginated(Integer offset, Integer maxResults) {
		return condicionDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return condicionDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Condicion entity) {
		if (entity.isNew())
			condicionDAO.save(entity);
		else
			condicionDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Condicion entity) {
		condicionDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		condicionDAO.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAllByEstado(Long idEstado) {
		return condicionDAO.findAllByEstado(idEstado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAllByCondicion(Long idCondicion) {
		return condicionDAO.findAllByCondicion(idCondicion);
	}

}
