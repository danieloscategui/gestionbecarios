package com.dospe.gestionbecarios.dao;

import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Asignacion;

@Repository
public class AsignacionDAO extends AbstractHibernateDAO<Asignacion> {
	public AsignacionDAO() {
		setClazz(Asignacion.class);
	}
}
