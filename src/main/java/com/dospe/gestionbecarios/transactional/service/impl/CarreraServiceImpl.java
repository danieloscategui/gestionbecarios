package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.model.Carrera;
import com.dospe.gestionbecarios.persistence.repository.CarreraRepository;
import com.dospe.gestionbecarios.transactional.service.CarreraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("carreraService")
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	@Qualifier("carreraRepository")
	private CarreraRepository carreraRepository;

	public void setCarreraRepository(CarreraRepository carreraRepository) {
		this.carreraRepository = carreraRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Carrera> findAll() {
		return carreraRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Carrera entity) {
		carreraRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Carrera findById(Long id) {
		return carreraRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		carreraRepository.deleteById(id);
	}

	@Override
	public Page<Carrera> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

}
