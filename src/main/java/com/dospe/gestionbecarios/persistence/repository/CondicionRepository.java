package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.model.Condicion;


@Repository("condicionRepository")
public interface CondicionRepository extends JpaRepository<Condicion, Long>{
	
//	@SuppressWarnings("unchecked")
//	public List<Condicion> findAllByEstado(Long idEstado){
//		Query query = getCurrentSession().createQuery("SELECT c FROM Condicion c WHERE c.estado.idEstado := idEstado");
//		query.setParameter("idEstado", idEstado);
//		return query.list();
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Condicion> findAllByCondicion(Long idCondicion){
//		Query query = getCurrentSession().createQuery("SELECT c FROM Condicion c WHERE c.idSubCondicion := idCondicion");
//		query.setParameter("idCondicion", idCondicion);
//		return query.list();
//	}
}

