package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Carrera;
import com.dospe.gestionbecarios.persistence.repository.CarreraRepository;
import com.dospe.gestionbecarios.transactional.service.CarreraService;


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

	@Override
	@Transactional(readOnly=true)
	public List<Carrera> findAllByBeca(Long idBeca) {
		return carreraRepository.findAllByBeca(idBeca);
	}

	@Override
	@Transactional(readOnly=true)
	public boolean existsByIdBecaAndDescripcionIgnoreCase(Long idBeca, String descripcion) {
		return carreraRepository.existsByIdBecaAndDescripcionIgnoreCase(idBeca, descripcion);
	}

}
