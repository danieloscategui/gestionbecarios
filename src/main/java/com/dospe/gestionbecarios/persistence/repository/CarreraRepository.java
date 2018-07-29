package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Carrera;

@Repository("carreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

}
