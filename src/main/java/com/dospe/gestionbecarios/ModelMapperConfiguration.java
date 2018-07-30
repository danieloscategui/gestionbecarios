package com.dospe.gestionbecarios;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dospe.gestionbecarios.controller.dto.CarreraDTO;
import com.dospe.gestionbecarios.controller.dto.CarreraListDTO;
import com.dospe.gestionbecarios.controller.dto.IesDTO;
import com.dospe.gestionbecarios.controller.dto.IesListDTO;
import com.dospe.gestionbecarios.controller.dto.SedeEstudioDTO;
import com.dospe.gestionbecarios.controller.dto.SedeEstudioListDTO;
import com.dospe.gestionbecarios.persistence.domain.Carrera;
import com.dospe.gestionbecarios.persistence.domain.Ies;
import com.dospe.gestionbecarios.persistence.domain.SedeEstudio;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		modelMapper.addMappings(new PropertyMap<Ies, IesListDTO>() {
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
		
		modelMapper.addMappings(new PropertyMap<Carrera, CarreraListDTO>() {
			protected void configure() {
				map().setBeca(source.getBeca().getShortName());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<Carrera, CarreraDTO>() {
			protected void configure() {
				map().setIdBeca(source.getBeca().getId());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<SedeEstudio, SedeEstudioListDTO>() {
			protected void configure() {
				map().setIes(source.getIes().getNombre());
			}
		});
		
		modelMapper.addMappings(new PropertyMap<SedeEstudio, SedeEstudioDTO>() {
			protected void configure() {
				map().setIdIes(source.getIes().getId());
			}
		});
		
		return modelMapper;
	}
	
}
