package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Beca;

@Repository
public class BecaDAO extends AbstractHibernateDAO<Beca>{
	public BecaDAO() {
		setClazz(Beca.class);
	}
}
