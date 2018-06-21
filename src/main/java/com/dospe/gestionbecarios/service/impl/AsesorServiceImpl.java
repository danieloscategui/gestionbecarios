package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.dao.AsesorDAO;
import com.dospe.gestionbecarios.model.Asesor;
import com.dospe.gestionbecarios.service.AsesorService;

@Service
public class AsesorServiceImpl implements AsesorService {

	@Autowired
	private AsesorDAO asesorDAO;
	
	public void setAsesorDAO(AsesorDAO asesorDAO) {
		this.asesorDAO = asesorDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Asesor findOne(Long id) {
		return asesorDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asesor> findAll() {
		return asesorDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asesor> findAllPaginated(Integer offset, Integer maxResults) {
		return asesorDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return asesorDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Asesor entity) {
		if(entity.isNew())
			asesorDAO.save(entity);
		else
			asesorDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Asesor entity) {
		asesorDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		asesorDAO.deleteById(id);
	}

}
