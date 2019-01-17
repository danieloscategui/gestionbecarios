package com.dospe.gestionbecarios.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;

@Repository("sedeEstudioRepository")
public interface SedeEstudioRepository extends JpaRepository<SedeEstudio, Long>{
	
	@Query(value= "select c from SedeEstudio c where c.idIes = :idIes")
	List<SedeEstudio> findAllByIes(Long idIes);
	
	public boolean existsBySedeIgnoreCaseAndIdIes(String sede, Long idIes);
	
}
