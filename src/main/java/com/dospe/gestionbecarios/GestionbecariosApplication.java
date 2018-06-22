package com.dospe.gestionbecarios;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class GestionbecariosApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GestionbecariosApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GestionbecariosApplication.class, args);
	}
	
	@Bean
	public TomcatServletWebServerFactory containerFactory() {
		return new TomcatServletWebServerFactory() {
			@Value("#{ environment['persistence.db.datasource'] }")
			private String datasource;

		    @Value("#{ environment['persistence.db.factory'] }")
			private String factory;

		    @Value("#{ environment['persistence.db.driver_class'] }")
			private String driver_class;

		    @Value("#{ environment['persistence.db.url'] }")
			private String url;

		    @Value("#{ environment['persistence.db.pool.maxActive'] }")
			private String maxActive;

		    @Value("#{ environment['persistence.db.pool.maxIdle'] }")
			private String maxIdle;

		    @Value("#{ environment['persistence.db.pool.maxWait'] }")
			private String maxWait;

		    @Value("#{ environment['persistence.db.username'] }")
			private String username;

		    @Value("#{ environment['persistence.db.password'] }")
			private String password;
		    
		    @Override
		    protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
		    	tomcat.enableNaming();
		    	return super.getTomcatWebServer(tomcat);
		    }
		    
		    @Override
		    protected void postProcessContext(Context context) {
		    	ContextResource resource = new ContextResource();
		    	resource.setName(this.datasource);
		    	resource.setType(DataSource.class.getName());
		    	resource.setProperty("factory", this.factory);
				resource.setProperty("driverClassName", this.driver_class);
				resource.setProperty("url", this.url);
				resource.setProperty("maxActive", this.maxActive);
				resource.setProperty("maxIdle", this.maxIdle);
				resource.setProperty("maxWait", this.maxWait);
				resource.setProperty("username", this.username);
				resource.setProperty("password", this.password);
				
				context.getNamingResources().addResource(resource);
		    }
		};
	}
	 
}
