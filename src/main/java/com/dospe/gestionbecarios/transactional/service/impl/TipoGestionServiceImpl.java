package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.TipoGestion;
import com.dospe.gestionbecarios.persistence.repository.TipoGestionRepository;
import com.dospe.gestionbecarios.transactional.service.TipoGestionService;

@Service("tipoGestionService")
public class TipoGestionServiceImpl implements TipoGestionService {

	@Autowired
	@Qualifier("tipoGestionRepository")
	private TipoGestionRepository tipoGestionRepository;
	
	public void setTipoGestionRepository(TipoGestionRepository tipoGestionRepository) {
		this.tipoGestionRepository = tipoGestionRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<TipoGestion> findAll() {
		return tipoGestionRepository.findAll();
	}

	@Override
	@Transactional
	public void save(TipoGestion entity) {
		tipoGestionRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoGestion findById(Long id) {
		return tipoGestionRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		tipoGestionRepository.deleteById(id);
	}

	@Override
	public Page<TipoGestion> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public boolean existsByDescripcionIgnoreCase(String descripcion) {
		return tipoGestionRepository.existsByDescripcionIgnoreCase(descripcion);
	}


}
