package com.dospe.gestionbecarios;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dospe.gestionbecarios.controller.dto.CarreraListDTO;
import com.dospe.gestionbecarios.controller.dto.IesListDTO;
import com.dospe.gestionbecarios.persistence.domain.Carrera;
import com.dospe.gestionbecarios.persistence.domain.Ies;

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
		
		modelMapper.addMappings(new PropertyMap<Carrera, CarreraListDTO>() {
			protected void configure() {
				map().setBeca(source.getBeca().getShortName());
			}
		});
		
		return modelMapper;
	}
	
}
