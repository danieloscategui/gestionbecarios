package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.SedeEstudio;

@Repository
public class SedeEstudioDAO extends AbstractHibernateDAO<SedeEstudio>{
	public SedeEstudioDAO() {
		setClazz(SedeEstudio.class);
	}
}
