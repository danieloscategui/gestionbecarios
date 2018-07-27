package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.model.Beca;


@Repository("becaRepository")
public interface BecaRepository extends JpaRepository<Beca, Long>{

}
