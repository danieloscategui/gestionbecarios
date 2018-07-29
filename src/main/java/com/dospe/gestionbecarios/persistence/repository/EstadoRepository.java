package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Estado;

@Repository("estadoRepository")
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
