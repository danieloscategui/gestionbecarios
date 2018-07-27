package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.model.Carrera;


@Repository("carreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera, Long> {

}
