package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Ies;

@Repository
public class IesDAO extends AbstractHibernateDAO<Ies> {
	public IesDAO() {
		setClazz(Ies.class);
	}
}
