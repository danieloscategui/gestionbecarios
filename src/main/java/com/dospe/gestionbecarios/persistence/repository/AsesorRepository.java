package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Asesor;

@Repository("asesorRepository")
public interface AsesorRepository extends JpaRepository<Asesor, Long>{

}
