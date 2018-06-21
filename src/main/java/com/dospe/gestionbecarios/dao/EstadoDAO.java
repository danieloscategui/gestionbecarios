package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Estado;

@Repository
public class EstadoDAO extends AbstractHibernateDAO<Estado> {
	public EstadoDAO() {
		setClazz(Estado.class);
	}
}
