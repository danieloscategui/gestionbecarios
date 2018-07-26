package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.model.Asignacion;
import com.dospe.gestionbecarios.persistence.repository.AsignacionRepository;
import com.dospe.gestionbecarios.transactional.service.AsignacionService;

@Service("asignacionService")
public class AsignacionServiceImpl implements AsignacionService{

	@Autowired
	@Qualifier("asignacionRepository")
	private AsignacionRepository asignacionRepository;
	
	public void setAsignacionRepository(AsignacionRepository asignacionRepository) {
		this.asignacionRepository = asignacionRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Asignacion> findAll() {
		return asignacionRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Asignacion entity) {
		asignacionRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public Asignacion findById(Long id) {
		return asignacionRepository.findById(id).orElse(null);
	}

	@Override
	public void remove(Long id) {
		asignacionRepository.deleteById(id);
	}

	@Override
	public Page<Asignacion> findPaginated(int page, int size, String orden, String campo) {
		// TODO Auto-generated method stub
		return null;
	}


}
