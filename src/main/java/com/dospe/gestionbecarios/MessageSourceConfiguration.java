package com.dospe.gestionbecarios;

import java.nio.charset.StandardCharsets;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfiguration {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setDefaultEncoding(StandardCharsets.ISO_8859_1.name());
//		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	// @Bean
	// public LocalValidatorFactoryBean getValidator() {
	// LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	// bean.setValidationMessageSource(messageSource());
	// return bean;
	// }

	/*
	 * @Bean public LocaleResolver localeResolver() { SessionLocaleResolver
	 * localeResolver = new SessionLocaleResolver(); Locale spanish = new
	 * Locale("es", "PE"); localeResolver.setDefaultLocale(spanish); return
	 * localeResolver; }
	 */
}
