package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.model.Condicion;
import com.dospe.gestionbecarios.persistence.repository.CondicionRepository;
import com.dospe.gestionbecarios.transactional.service.CondicionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Collection<Condicion> findAll() {
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
	public Collection<Condicion> findAllByEstado(Long idEstado) {
		return null;
	}

	@Override
	public Collection<Condicion> findAllByCondicion(Long idCondicion) {
		return null;
	}
	
}
