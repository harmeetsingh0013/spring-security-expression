/**
 * 
 */
package com.programmersnest.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.programmersnest.config.security.SpringSecurityConfig;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Order(1)
public class ApiInitializrConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{SpringDataConfig.class, SpringSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ApplicationContextConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
