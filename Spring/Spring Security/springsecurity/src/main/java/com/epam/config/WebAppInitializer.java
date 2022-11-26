package com.epam.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] config = {MyAppConfig.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mappings = {"/"};
		return mappings;
	}

}
