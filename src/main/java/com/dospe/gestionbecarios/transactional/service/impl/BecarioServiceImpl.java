package com.dospe.gestionbecarios.transactional.service.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.persistence.domain.Asignacion;
import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.persistence.repository.AsignacionRepository;
import com.dospe.gestionbecarios.persistence.repository.BecarioRepository;
import com.dospe.gestionbecarios.transactional.service.BecarioService;


@Service("becarioService")
public class BecarioServiceImpl implements BecarioService {

	private static final Logger logger = LoggerFactory.getLogger(BecarioServiceImpl.class);
	
	@Autowired
	@Qualifier("becarioRepository")
	private BecarioRepository becarioRepository;
	
	@Autowired
	@Qualifier("asignacionRepository")
	private AsignacionRepository asignacionRepository;
	
	public void setBecarioRepository(BecarioRepository becarioRepository) {
		this.becarioRepository = becarioRepository;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Becario> findAll() {
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
	public Collection<Becario> findBecariosPorBeca(Long idBeca) {
		return becarioRepository.findAllByBeca(idBeca);
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

	@Override
	public void save(Becario becario, Asignacion asignacion) {
		Asignacion asignacionExistente = asignacionRepository.findByCarreraSedeAsesor(
								asignacion.getIdCarrera(),
								asignacion.getIdSedeEstudio(),
								asignacion.getIdAsesor());
		
		if (asignacionExistente == null) {
			logger.info("No existe asignación - se procede a actualizar");
			asignacionRepository.save(asignacion);
			logger.info("Asignacion creada: "+ asignacion.getIdAsignacion());
			logger.info("se asigna al becario - asignacion");
			becario.setIdAsignacion(asignacion.getIdAsignacion());
			logger.info("Asignacion: " + becario.getIdAsignacion());
		} else {
			logger.info("la asignacion existe: " + asignacionExistente.getIdAsignacion());
			becario.setIdAsignacion(asignacionExistente.getIdAsignacion());;
			logger.info("se asigna la becario - asignacionExistente");
			logger.info("AsignacionExistente: "+ becario.getIdAsignacion());
		} 
		
		becarioRepository.save(becario);
	}
	
}
