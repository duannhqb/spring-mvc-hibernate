package edu.poly.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebInitializer implements WebApplicationInitializer {

//	private String TMP_FOLDER = "/tmp";
//	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(SpringConfiguration.class);

		ServletRegistration.Dynamic appServlet = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");

		// size file upload		
//		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, MAX_UPLOAD_SIZE,
//				MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//		appServlet.setMultipartConfig(multipartConfigElement);

		// UTF8 Charactor Filter.
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);
		servletContext.addFilter("encodingFilter", characterEncodingFilter)
		.addMappingForUrlPatterns(null, false, "/*");
	}

}