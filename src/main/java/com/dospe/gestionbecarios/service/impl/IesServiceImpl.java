package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.dao.IesDAO;
import com.dospe.gestionbecarios.model.Ies;
import com.dospe.gestionbecarios.service.IesService;

@Service
public class IesServiceImpl implements IesService {

	@Autowired
	private IesDAO iesDAO;
	
	public void setIesDAO(IesDAO iesDAO) {
		this.iesDAO = iesDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Ies findOne(Long id) {
		return iesDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ies> findAll() {
		return iesDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ies> findAllPaginated(Integer offset, Integer maxResults) {
		return iesDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return iesDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Ies entity) {
		if (entity.isNew())
			iesDAO.save(entity);
		else
			iesDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Ies entity) {
		iesDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		iesDAO.deleteById(id);
	}

}
