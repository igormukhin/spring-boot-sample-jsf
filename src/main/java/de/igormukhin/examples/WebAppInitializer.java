package de.igormukhin.examples;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		logger.info("--- WebAppInitializer INITIALIZER! ---");
		
		servletContext.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
		servletContext.setInitParameter("contextConfigLocation", ApplicationConfiguration.class.getName());
		servletContext.addListener(ContextLoaderListener.class);
	}

}
