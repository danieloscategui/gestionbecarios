package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Beca;
import com.dospe.gestionbecarios.persistence.repository.BecaRepository;
import com.dospe.gestionbecarios.transactional.service.BecaService;


@Service("becaService")
public class BecaServiceImpl implements BecaService {

	@Autowired
	@Qualifier("becaRepository")
	private BecaRepository becaRepository;
	
	public void setBecaRepository(BecaRepository becaRepository){
		this.becaRepository = becaRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Beca> findAll() {
		return becaRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Beca entity) {
		becaRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Beca findById(Long id) {
		return becaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		becaRepository.deleteById(id);
	}

	@Override
	public Page<Beca> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}
	
}
