package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Ies;

@Repository("iesRepository")
public interface IesRepository extends JpaRepository<Ies, Long> {

}
