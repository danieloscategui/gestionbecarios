package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Condicion;
import com.dospe.gestionbecarios.persistence.repository.CondicionRepository;
import com.dospe.gestionbecarios.transactional.service.CondicionService;

@Service("condicionService")
public class CondicionServiceImpl implements CondicionService {

	@Autowired
	@Qualifier("condicionRepository")
	private CondicionRepository condicionRepository;

	public void setCondicionRepository(CondicionRepository condicionRepository) {
		this.condicionRepository = condicionRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAll() {
		return condicionRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Condicion entity) {
		condicionRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Condicion findById(Long id) {
		return condicionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		condicionRepository.deleteById(id);
	}

	@Override
	public Page<Condicion> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAllByEstado(Long idEstado) {
		return condicionRepository.findAllByEstado(idEstado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Condicion> findAllByEstadoAndCondicion(Long idEstado, Long idCondicion) {
		return condicionRepository.findAllByEstadoAndCondicion(idEstado, idCondicion);
	}

	@Override
	public boolean existsByDescripcionIgnoreCaseAndIdEstado(String nombre, Long idEstado) {
		return condicionRepository.existsByDescripcionIgnoreCaseAndIdEstado(nombre, idEstado);
	}
	
}
