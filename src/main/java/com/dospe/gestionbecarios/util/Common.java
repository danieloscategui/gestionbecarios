package com.dospe.gestionbecarios.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class Common {
	
	private static final Locale locale = new Locale("es");
	
	@Autowired
    private MessageSource messageSource;

	protected String getMessageSource(String code, Object[] args) {
        return messageSource.getMessage(code, args, locale);
    }
	
	protected String getMessageSource(String code) {
		return messageSource.getMessage(code, null, locale);
	}
}
