package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.persistence.domain.BecarioView;
import com.dospe.gestionbecarios.persistence.repository.BecarioRepository;
import com.dospe.gestionbecarios.transactional.service.BecarioService;


@Service("becarioService")
public class BecarioServiceImpl implements BecarioService {

	@Autowired
	@Qualifier("becarioRepository")
	private BecarioRepository becarioRepository;
	
	public void setBecarioRepository(BecarioRepository becarioRepository) {
		this.becarioRepository = becarioRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Becario> findAll() {
		return becarioRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Becario entity) {
		becarioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Becario findById(Long id) {
		return becarioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		becarioRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Becario> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<BecarioView> findBecariosPorBeca(Long idBeca) {
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Becario> findAllByBecaAndDni(Long idBeca, String dni, int page, int size) {
		return becarioRepository.findAllByBecaAndDNI(idBeca, dni, PageRequest.of(page-1, size));
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Becario> findAllByBeca(Long idBeca, int page, int size) {
		return becarioRepository.findAllByBeca(idBeca, PageRequest.of(page-1, size));
	}
	
}
