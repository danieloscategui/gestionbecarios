package com.dospe.gestionbecarios.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Condicion;

@Repository("condicionRepository")
public interface CondicionRepository extends JpaRepository<Condicion, Long>{
	
	@Query(value= "select c from Condicion c where c.idEstado = :idEstado ")
	public List<Condicion> findAllByEstado(Long idEstado);
}

