package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Carrera;

@Repository
public class CarreraDAO extends AbstractHibernateDAO<Carrera> {
	public CarreraDAO() {
		setClazz(Carrera.class);
	}
}
