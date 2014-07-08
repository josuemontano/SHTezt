package com.hanovit.app.init;

import com.hanovit.app.config.ApplicationConfigurer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.*;

/**
 *
 * @author Josue Montano
 */
public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //context.setConfigLocation("com.hanovit.app.config"); Alternative configuration setting
        context.register(ApplicationConfigurer.class);
        context.setServletContext(servletContext);
        context.setDisplayName("SHTezt");
        
        servletContext.addListener(new ContextLoaderListener(context));
        
        Dynamic servlet = servletContext.addServlet("api", new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/api/*");
    }
    
}
