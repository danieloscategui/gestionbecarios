package com.dospe.gestionbecarios.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dospe.gestionbecarios.persistence.domain.Asignacion;

@Repository("asignacionRepository")
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
	
	@Query(value="select a from Asignacion a "
			+" where a.idCarrera = :idCarrera "
			+" and a.idSedeEstudio = :idSedeEstudio "
			+" and a.idAsesor = :idAsesor")
	Asignacion findByCarreraSedeAsesor(Long idCarrera, Long idSedeEstudio, Long idAsesor);
}
