package com.dospe.gestionbecarios.persistence.repository;

import com.dospe.gestionbecarios.persistence.model.Asesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("asesorRepository")
public interface AsesorRepository extends JpaRepository<Asesor, Long>{

}
