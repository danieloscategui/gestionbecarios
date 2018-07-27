package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.model.TipoIes;


@Repository("tipoIesRepository")
public interface TipoIesRepository extends JpaRepository<TipoIes, Long> {

}
