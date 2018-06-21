package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Asesor;

@Repository
public class AsesorDAO extends AbstractHibernateDAO<Asesor> {
	public AsesorDAO() {
		setClazz(Asesor.class);
	}
}
