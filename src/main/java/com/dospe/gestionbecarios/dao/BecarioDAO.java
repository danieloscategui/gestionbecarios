package com.dospe.gestionbecarios.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.dao.base.AbstractHibernateDAO;
import com.dospe.gestionbecarios.model.Becario;
import com.dospe.gestionbecarios.model.BecarioView;
import com.dospe.gestionbecarios.model.mapper.BecarioViewMapper;

@Repository
public class BecarioDAO extends AbstractHibernateDAO<Becario> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public BecarioDAO() {
		setClazz(Becario.class);
	}
	
	public List<BecarioView> findBecariosPorBeca(Long idBeca){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id_becario, dni, nombres, apellidos, carrera, ies, sede, estado, asesor ");
		sql.append("FROM vw_gb_becario WHERE id_beca = ? ");
		sql.append("ORDER BY nombres ASC");
		return jdbcTemplate.query(sql.toString(), new Object[]{idBeca}, new BecarioViewMapper());
	}
	
	public List<Becario> findBecariosPorBecaPaginated(Long idBeca, Integer offset, Integer maxResults){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Becario> findByDNI(String dni){
		return getCurrentSession()
				.createCriteria(Becario.class)
				.add(Restrictions.eq("dni", dni))
				.addOrder(Order.asc("idBecario"))
				.list();
	}
	
	public Long countByBeca(Long idBeca){
		return 0L;
	}
}
