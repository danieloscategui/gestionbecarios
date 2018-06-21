package com.dospe.gestionbecarios.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dospe.gestionbecarios.dao.BecarioDAO;
import com.dospe.gestionbecarios.model.Becario;
import com.dospe.gestionbecarios.model.BecarioView;
import com.dospe.gestionbecarios.service.BecarioService;

@Service
public class BecarioServiceImpl implements BecarioService {

	@Autowired
	private BecarioDAO becarioDAO;
	
	public void setBecarioDAO(BecarioDAO becarioDAO) {
		this.becarioDAO = becarioDAO;
	}

	@Override
	@Transactional(readOnly=true)
	public Becario findOne(Long id) {
		return becarioDAO.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Becario> findAll() {
		return becarioDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Becario> findAllPaginated(Integer offset, Integer maxResults) {
		return becarioDAO.findAllPaginated(offset, maxResults);
	}

	@Override
	@Transactional(readOnly=true)
	public Long count() {
		return becarioDAO.count();
	}

	@Override
	@Transactional
	public String saveOrUpdate(Becario entity) {
		if (entity.isNew())
			becarioDAO.save(entity);
		else
			becarioDAO.update(entity);
		return null;
	}

	@Override
	@Transactional
	public void delete(Becario entity) {
		becarioDAO.delete(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		becarioDAO.deleteById(id);
	}

	@Override
	public List<BecarioView> findBecariosPorBeca(Long idBeca) {
		return becarioDAO.findBecariosPorBeca(idBeca);
	}

	@Override
	public List<Becario> findBecariosPorBecaPaginated(Long idBeca, Integer offset, Integer maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Becario> findByDNI(String DNI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countByBeca(Long idBeca) {
		// TODO Auto-generated method stub
		return null;
	}

}
