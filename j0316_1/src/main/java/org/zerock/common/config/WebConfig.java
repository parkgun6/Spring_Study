package org.zerock.common.config;


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.zerock.board.config.BoardConfig;
import org.zerock.time.config.TimeConfig;

//이 파일은 웬만하면 건드리지 않는다.
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//웬만하면 각 패키지의 컨피그파일은 여기에 넣어준다.
		return new Class[] {
				CommonConfig.class, 
				TimeConfig.class, 
				BoardConfig.class
				};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };	
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
		
		MultipartConfigElement multipartConfig = 
				new MultipartConfigElement("C:\\upload\\temp",20971520,41943040,20971520);
		
		registration.setMultipartConfig(multipartConfig);
	}
}
