package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.model.TipoGestion;
import com.dospe.gestionbecarios.repository.TipoGestionRepository;
import com.dospe.gestionbecarios.service.TipoGestionService;

@Service
public class TipoGestionServiceImpl implements TipoGestionService {

	@Autowired
	private TipoGestionRepository tipoGestionDAO;
	
	public void setTipoGestionDAO(TipoGestionRepository tipoGestionDAO) {
		this.tipoGestionDAO = tipoGestionDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public TipoGestion findOne(Long id) {
		return tipoGestionDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoGestion> findAll() {
		return tipoGestionDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoGestion> findAllPaginated(Integer offset, Integer maxResults) {
		return tipoGestionDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return tipoGestionDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(TipoGestion entity) {
		if (entity.isNew())
			tipoGestionDAO.save(entity);
		else
			tipoGestionDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(TipoGestion entity) {
		tipoGestionDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tipoGestionDAO.deleteById(id);
	}

}
