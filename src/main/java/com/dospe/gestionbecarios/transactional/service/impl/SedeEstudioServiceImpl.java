package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;
import com.dospe.gestionbecarios.persistence.repository.SedeEstudioRepository;
import com.dospe.gestionbecarios.transactional.service.SedeEstudioService;

@Service("sedeEstudioService")
public class SedeEstudioServiceImpl implements SedeEstudioService {

	@Autowired
	@Qualifier("sedeEstudioRepository")
	private SedeEstudioRepository sedeEstudioRepository;
	
	public void setSedeEstudioRepository(SedeEstudioRepository sedeEstudioRepository) {
		this.sedeEstudioRepository = sedeEstudioRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<SedeEstudio> findAll() {
		return sedeEstudioRepository.findAll();
	}

	@Override
	@Transactional
	public void save(SedeEstudio entity) {
		sedeEstudioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public SedeEstudio findById(Long id) {
		return sedeEstudioRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		sedeEstudioRepository.deleteById(id);
	}

	@Override
	public Page<SedeEstudio> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

}
