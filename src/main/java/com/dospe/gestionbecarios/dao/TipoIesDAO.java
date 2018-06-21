package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.TipoIes;

@Repository
public class TipoIesDAO extends AbstractHibernateDAO<TipoIes> {
	public TipoIesDAO() {
		setClazz(TipoIes.class);
	}
}
