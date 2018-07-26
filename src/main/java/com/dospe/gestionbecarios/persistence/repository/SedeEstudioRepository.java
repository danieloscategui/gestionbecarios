package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.model.SedeEstudio;

@Repository
public interface SedeEstudioRepository extends JpaRepository<SedeEstudio, Long>{

}
