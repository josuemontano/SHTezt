package com.hanovit.app.init;

import com.hanovit.app.config.ApplicationConfigurer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author josuemontano
 */
public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfigurer.class);
        
        servletContext.addListener(new ContextLoaderListener(context));
    
        context.setServletContext(servletContext);
        context.setDisplayName("SHTezt");
        
        Dynamic servlet = servletContext.addServlet("api", new DispatcherServlet(context));
        servlet.addMapping("/api/*");
        servlet.setLoadOnStartup(1);
    }
    
}
