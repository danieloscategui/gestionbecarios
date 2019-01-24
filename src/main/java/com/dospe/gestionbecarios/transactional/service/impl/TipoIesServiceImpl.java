package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.TipoIes;
import com.dospe.gestionbecarios.persistence.repository.TipoIesRepository;
import com.dospe.gestionbecarios.transactional.service.TipoIesService;

@Service("tipoIesService")
public class TipoIesServiceImpl implements TipoIesService {

	@Autowired
	@Qualifier("tipoIesRepository")
	private TipoIesRepository tipoIesRepository;
	
	public void setTipoIesRepository(TipoIesRepository tipoIesRepository) {
		this.tipoIesRepository = tipoIesRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoIes> findAll() {
		return tipoIesRepository.findAll();
	}

	@Override
	@Transactional
	public void save(TipoIes entity) {
		tipoIesRepository.save(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoIes findById(Long id) {
		return tipoIesRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void remove(Long id) {
		tipoIesRepository.deleteById(id);
	}

	@Override
	public Page<TipoIes> findPaginated(int page, int size, String orden, String campo) {
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public boolean existsByDescripcionIgnoreCase(String descripcion) {
		return tipoIesRepository.existsByDescripcionIgnoreCase(descripcion);
	}


}
