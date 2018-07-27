package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import com.dospe.gestionbecarios.persistence.model.Estado;
import com.dospe.gestionbecarios.persistence.repository.EstadoRepository;
import com.dospe.gestionbecarios.transactional.service.EstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	@Qualifier("estadoRepository")
	private EstadoRepository estadoRepository;
	
	public void setEstadoRepository(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Estado entity) {
		estadoRepository.save(entity);
	}

	@Override
	@Transactional
	public Estado findById(Long id) {
		return estadoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		estadoRepository.deleteById(id);
	}

	@Override
	public Page<Estado> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

}
