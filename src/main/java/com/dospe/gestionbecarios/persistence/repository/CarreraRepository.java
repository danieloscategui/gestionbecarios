package com.dospe.gestionbecarios.persistence.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Carrera;

@Repository("carreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
	public boolean existsByIdBecaAndDescripcionIgnoreCase(Long idBeca, String descripcion);
	
	@Query(value= "select c from Carrera c where c.idBeca = :idBeca ")
	Page<Carrera> findAllByBeca(Long idBeca, Pageable pageable);
	
	@Query(value= "select c from Carrera c where c.idBeca = :idBeca ")
	List<Carrera> findAllByBeca(Long idBeca);
}
