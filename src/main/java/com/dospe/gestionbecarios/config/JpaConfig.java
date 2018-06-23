package com.dospe.gestionbecarios.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
	@Value("#{ environment['persistence.db.datasource'] }")
	private String datasource;

    @Value("#{ environment['persistence.db.domain'] }")
	private String domain;

    @Value("#{ environment['persistence.db.dialect'] }")
	private String dialect;

    @Value("#{ environment['persistence.db.show_sql'] }")
	private String show_sql;
    
    @Bean
    public DataSource dataSource() {
    	final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
    	dsLookup.setResourceRef(true);
    	DataSource dataSource = null;
    	try {
    		System.out.println("Datasource ======> " + this.datasource);
			dataSource = dsLookup.getDataSource(this.datasource);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    	LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    	em.setDataSource(this.dataSource());
    	em.setPackagesToScan(new String[] {this.domain});
    	
    	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	em.setJpaVendorAdapter(vendorAdapter);
    	em.setJpaProperties(getPropertiesHibernate());
    	return em;
    };
    
    private Properties getPropertiesHibernate() {
    	Properties properties = new Properties();
    	properties.setProperty("hibernate.dialect", this.dialect);
		properties.setProperty("hibernate.show_sql", this.show_sql);
    	return properties;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
    	JpaTransactionManager  transactionManager = new JpaTransactionManager();
    	transactionManager.setEntityManagerFactory(emf);
    	return transactionManager;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    	return new PersistenceExceptionTranslationPostProcessor();
    }
    
}
