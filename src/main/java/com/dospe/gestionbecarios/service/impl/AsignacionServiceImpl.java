package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.dao.AsignacionDAO;
import com.dospe.gestionbecarios.model.Asignacion;
import com.dospe.gestionbecarios.service.AsignacionService;

@Service
public class AsignacionServiceImpl implements AsignacionService{

	@Autowired
	private AsignacionDAO asignacionDAO;
	
	public void setAsignacionDAO(AsignacionDAO asignacionDAO) {
		this.asignacionDAO = asignacionDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Asignacion findOne(Long id) {
		return asignacionDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asignacion> findAll() {
		return asignacionDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asignacion> findAllPaginated(Integer offset, Integer maxResults) {
		return asignacionDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return asignacionDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Asignacion entity) {
		if (entity.isNew())
			asignacionDAO.save(entity);
		else
			asignacionDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Asignacion entity) {
		asignacionDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		asignacionDAO.deleteById(id);
	}

}
