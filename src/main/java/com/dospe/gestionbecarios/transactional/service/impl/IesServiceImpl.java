package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Ies;
import com.dospe.gestionbecarios.persistence.repository.IesRepository;
import com.dospe.gestionbecarios.transactional.service.IesService;

@Service("iesService")
public class IesServiceImpl implements IesService {

	@Autowired
	@Qualifier("iesRepository")
	private IesRepository iesRepository;
	
	public void setIesRepository(IesRepository iesRepository) {
		this.iesRepository = iesRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Ies> findAll() {
		return iesRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Ies entity) {
		iesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Ies findById(Long id) {
		return iesRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		iesRepository.deleteById(id);
	}

	@Override
	public Page<Ies> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}
}
