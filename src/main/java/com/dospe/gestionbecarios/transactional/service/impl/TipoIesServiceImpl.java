package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.model.TipoIes;
import com.dospe.gestionbecarios.repository.TipoIesRepository;
import com.dospe.gestionbecarios.service.TipoIesService;

@Service
public class TipoIesServiceImpl implements TipoIesService {

	@Autowired
	private TipoIesRepository tipoIesDAO;
	
	public void setTipoIesDAO(TipoIesRepository tipoIesDAO) {
		this.tipoIesDAO = tipoIesDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public TipoIes findOne(Long id) {
		return tipoIesDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoIes> findAll() {
		return tipoIesDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoIes> findAllPaginated(Integer offset, Integer maxResults) {
		return tipoIesDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return tipoIesDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(TipoIes entity) {
		if (entity.isNew())
			tipoIesDAO.save(entity);
		else
			tipoIesDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(TipoIes entity) {
		tipoIesDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		tipoIesDAO.deleteById(id);;
	}

}
