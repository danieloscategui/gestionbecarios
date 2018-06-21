package com.dospe.gestionbecarios.service;

import java.util.List;

import com.dospe.gestionbecarios.model.Becario;
import com.dospe.gestionbecarios.model.BecarioView;
import com.dospe.gestionbecarios.service.base.CRUDService;


public interface BecarioService extends CRUDService<Becario> {
	
	public List<BecarioView> findBecariosPorBeca(Long idBeca);
	public List<Becario> findBecariosPorBecaPaginated(Long idBeca, Integer offset, Integer maxResults);
	public List<Becario> findByDNI(String DNI);
	public Long countByBeca(Long idBeca);

}
