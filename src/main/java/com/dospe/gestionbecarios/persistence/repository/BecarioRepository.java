package com.dospe.gestionbecarios.persistence.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Becario;

@Repository("becarioRepository")
public interface BecarioRepository extends JpaRepository<Becario, Long> {

//	@Autowired
//	JdbcTemplate jdbcTemplate;
	
	
//	public List<BecarioView> findBecariosPorBeca(Long idBeca){
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT id_becario, dni, nombres, apellidos, carrera, ies, sede, estado, asesor ");
//		sql.append("FROM vw_gb_becario WHERE id_beca = ? ");
//		sql.append("ORDER BY nombres ASC");
//		return jdbcTemplate.query(sql.toString(), new Object[]{idBeca}, new BecarioViewMapper());
//	}

//	public List<Becario> findBecariosPorBecaPaginated(Long idBeca, Integer offset, Integer maxResults){
//		return null;
//	}
	
//	@SuppressWarnings("unchecked")
//	public List<Becario> findByDNI(String dni){
//		return getCurrentSession()
//				.createCriteria(Becario.class)
//				.add(Restrictions.eq("dni", dni))
//				.addOrder(Order.asc("idBecario"))
//				.list();
//	}
	
//	public Long countByBeca(Long idBeca){
//		return 0L;
//	}
	
	@Query(value= "select b from Becario b "
				+ "inner join fetch b.asignacion asig "
				+ "inner join fetch asig.carrera c "
				+ "inner join fetch c.beca bec "
				+ "where bec.id = :idBeca ")
	public Collection<Becario> findAllByBeca(@Param("idBeca") Long idBeca);
}
