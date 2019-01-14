package com.dospe.gestionbecarios.persistence.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Query(value= "select b from Becario b "
				+ "inner join b.asignacion asig "
				+ "inner join asig.carrera c "
				+ "inner join c.beca bec "
				+ "where bec.id = :idBeca ")
	Page<Becario> findAllByBeca(@Param("idBeca") Long idBeca, Pageable pageable);
	
	
	@Query(value= "select b from Becario b "
			+ "inner join b.asignacion asig "
			+ "inner join asig.carrera c "
			+ "inner join c.beca bec "
			+ "where bec.id = :idBeca ")
	Collection<Becario> findAllByBeca(@Param("idBeca") Long idBeca);
	
	@Query(value= "select b from Becario b "
			+ "inner join b.asignacion asig "
			+ "inner join asig.carrera c "
			+ "inner join c.beca bec "
			+ "where bec.id = :idBeca "
			+ "and b.dni = :dni ")
	Page<Becario> findAllByBecaAndDNI(@Param("idBeca") Long idBeca, @Param("dni") String dni, Pageable pageable);
	
//	public Collection<Becario> findByDni(String dni);

}
