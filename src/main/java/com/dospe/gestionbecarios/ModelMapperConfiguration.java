package com.dospe.gestionbecarios;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dospe.gestionbecarios.controller.dto.BecarioDTO;
import com.dospe.gestionbecarios.controller.dto.BecarioListDTO;
import com.dospe.gestionbecarios.controller.dto.CarreraDTO;
import com.dospe.gestionbecarios.controller.dto.CarreraTableListDTO;
import com.dospe.gestionbecarios.controller.dto.CondicionDTO;
import com.dospe.gestionbecarios.controller.dto.CondicionListDTO;
import com.dospe.gestionbecarios.controller.dto.IesDTO;
import com.dospe.gestionbecarios.controller.dto.IesTableListDTO;
import com.dospe.gestionbecarios.controller.dto.SedeEstudioDTO;
import com.dospe.gestionbecarios.controller.dto.SedeEstudioTableListDTO;
import com.dospe.gestionbecarios.persistence.domain.Becario;
import com.dospe.gestionbecarios.persistence.domain.Carrera;
import com.dospe.gestionbecarios.persistence.domain.Condicion;
import com.dospe.gestionbecarios.persistence.domain.Ies;
import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		modelMapper.addMappings(new PropertyMap<Ies, IesTableListDTO>() {
            protected void configure() {
                map().setTipoIes(source.getTipoIes().getDescripcion());
                map().setTipoGestion(source.getTipoGestion().getDescripcion());
            }
        });
		
		modelMapper.addMappings(new PropertyMap<Ies, IesDTO>() {
            protected void configure() {
                map().setIdTipoIes(source.getTipoIes().getId());
                map().setIdTipoGestion(source.getTipoGestion().getId());
            }
        });
		
		modelMapper.addMappings(new PropertyMap<Carrera, CarreraTableListDTO>() {
			protected void configure() {
				map().setBeca(source.getBeca().getShortName());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<Carrera, CarreraDTO>() {
			protected void configure() {
				map().setIdBeca(source.getBeca().getId());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<SedeEstudio, SedeEstudioTableListDTO>() {
			protected void configure() {
				map().setIes(source.getIes().getNombre());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<SedeEstudio, SedeEstudioDTO>() {
			protected void configure() {
				map().setIdIes(source.getIes().getId());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<Becario, BecarioListDTO>() {
			protected void configure() {
				map().setNombreCompleto(source.getFullName());
				map().setCarrera(source.getAsignacion().getCarrera().getDescripcion());
				map().setAsesor(source.getAsignacion().getAsesor().getNombre());
				map().setEstado(source.getEstado().getDescripcion());
			}
		});

		modelMapper.addMappings(new PropertyMap<Becario, BecarioDTO>() {
			protected void configure() {
				map().setIdAsesor(source.getAsignacion().getIdAsesor());
				map().setIdSedeEstudio(source.getAsignacion().getIdSedeEstudio());
				map().setIdCarrera(source.getAsignacion().getIdCarrera());
				map().setIdIes(source.getAsignacion().getSedeEstudio().getIdIes());
				map().setIdBeca(source.getAsignacion().getCarrera().getIdBeca());
				map().setIdCondicion(source.getIdCondicion());
				map().setIdEstado(source.getIdEstado());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<Condicion, CondicionDTO>() {
			protected void configure() {
				map().setId(source.getId());
				map().setDescripcion(source.getDescripcion());
				map().setIdEstado(source.getIdEstado());
				map().setIdPadre(source.getIdPadre());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<Condicion, CondicionListDTO>() {
			protected void configure() {
				map().setId(source.getId());
				map().setDescripcion(source.getDescripcion());
			}
		});
		
		return modelMapper;
	}
	
}
