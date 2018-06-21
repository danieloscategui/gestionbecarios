package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.dao.SedeEstudioDAO;
import com.dospe.gestionbecarios.model.SedeEstudio;
import com.dospe.gestionbecarios.service.SedeEstudioService;

@Service
public class SedeEstudioServiceImpl implements SedeEstudioService {

	@Autowired
	private SedeEstudioDAO sedeEstudioDAO;
	
	public void setSedeEstudioDAO(SedeEstudioDAO sedeEstudioDAO) {
		this.sedeEstudioDAO = sedeEstudioDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public SedeEstudio findOne(Long id) {
		return sedeEstudioDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<SedeEstudio> findAll() {
		return sedeEstudioDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<SedeEstudio> findAllPaginated(Integer offset, Integer maxResults) {
		return sedeEstudioDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return sedeEstudioDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(SedeEstudio entity) {
		if(entity.isNew())
			sedeEstudioDAO.save(entity);
		else
			sedeEstudioDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(SedeEstudio entity) {
		sedeEstudioDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		sedeEstudioDAO.deleteById(id);
	}

}
