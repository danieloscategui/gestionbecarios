package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.TipoGestion;

@Repository
public class TipoGestionDAO extends AbstractHibernateDAO<TipoGestion>{
	public TipoGestionDAO() {
		setClazz(TipoGestion.class);
	}
}
