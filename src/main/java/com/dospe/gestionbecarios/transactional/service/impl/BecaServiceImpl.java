package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.model.Beca;
import com.dospe.gestionbecarios.repository.BecaRepository;
import com.dospe.gestionbecarios.service.BecaService;

@Service
public class BecaServiceImpl implements BecaService {

	@Autowired
	private BecaRepository becaDAO;
	
	public void setBecaDAO(BecaRepository becaDAO){
		this.becaDAO = becaDAO;
	}
	
	@Override
	@Transactional(readOnly=true)
	public Beca findOne(Long id) {
		return becaDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Beca> findAll() {
		return becaDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Beca> findAllPaginated(Integer offset, Integer maxResults) {
		return becaDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return becaDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Beca entity) {
		String msg;
		if(entity.isNew()){
			becaDAO.save(entity);
			msg = "Beca guardada exitosamente";
		}
		else {
			becaDAO.update(entity);
			msg = "Beca actualizada exitosamente";
		}
		return msg;
	}

	@Override
	@Transactional
	public void delete(Beca entity) {
		becaDAO.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		becaDAO.deleteById(id);
	}

}
