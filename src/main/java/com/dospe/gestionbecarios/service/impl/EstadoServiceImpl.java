package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.dao.EstadoDAO;
import com.dospe.gestionbecarios.model.Estado;
import com.dospe.gestionbecarios.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoDAO estadoDAO;
	
	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Estado findOne(Long id) {
		return estadoDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Estado> findAll() {
		return estadoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Estado> findAllPaginated(Integer offset, Integer maxResults) {
		return estadoDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return estadoDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Estado entity) {
		if (entity.isNew())
			estadoDAO.save(entity);
		else
			estadoDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Estado entity) {
		estadoDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		estadoDAO.deleteById(id);
	}

}
