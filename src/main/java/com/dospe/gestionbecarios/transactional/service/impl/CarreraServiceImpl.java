package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.model.Carrera;
import com.dospe.gestionbecarios.repository.CarreraRepository;
import com.dospe.gestionbecarios.service.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private CarreraRepository carreraDAO;

	public void setCarreraDAO(CarreraRepository carreraDAO) {
		this.carreraDAO = carreraDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Carrera findOne(Long id) {
		return carreraDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Carrera> findAll() {
		return carreraDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Carrera> findAllPaginated(Integer offset, Integer maxResults) {
		return carreraDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return carreraDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Carrera entity) {
		if (entity.isNew())
			carreraDAO.save(entity);
		else
			carreraDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Carrera entity) {
		carreraDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		carreraDAO.deleteById(id);
	}

}
