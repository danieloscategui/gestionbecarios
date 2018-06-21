package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Condicion;

@Repository
public class CondicionDAO extends AbstractHibernateDAO<Condicion>{
	public CondicionDAO() {
		setClazz(Condicion.class);
	}
}
