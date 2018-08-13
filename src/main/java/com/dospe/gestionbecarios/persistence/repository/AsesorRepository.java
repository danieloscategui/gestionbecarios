package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Asesor;

@Repository("asesorRepository")
public interface AsesorRepository extends JpaRepository<Asesor, Long>{
	public boolean existsByNombreIgnoreCase(String nombre);
	
//	@Query(name="select a from Asesor a")
	public Page<Asesor> findAll(Pageable pageable);
}
