package com.dospe.gestionbecarios.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.dospe.gestionbecarios.persistence.repository")
public class RepositoryConfig {

}
