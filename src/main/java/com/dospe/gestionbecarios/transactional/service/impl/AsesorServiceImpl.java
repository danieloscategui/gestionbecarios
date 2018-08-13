package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Asesor;
import com.dospe.gestionbecarios.persistence.repository.AsesorRepository;
import com.dospe.gestionbecarios.transactional.service.AsesorService;

@Service("asesorService")
public class AsesorServiceImpl implements AsesorService {

	@Autowired
	@Qualifier("asesorRepository")
	private AsesorRepository asesorRepository;
	
	public void setAsesorRepository(AsesorRepository asesorRepository) {
		this.asesorRepository = asesorRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Asesor> findAll() {
		return asesorRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Asesor entity) {
		asesorRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Asesor findById(Long id) {
		return asesorRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		asesorRepository.deleteById(id);
	}

	@Override
	public Page<Asesor> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public boolean existsByNombreIgnoreCase(String nombre) {
		return asesorRepository.existsByNombreIgnoreCase(nombre);
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Asesor> findAllPaginated(int page, int size) {
		return asesorRepository.findAll(PageRequest.of(page-1, size));
	}

}
