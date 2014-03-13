package com.hanovit.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author josuemontano
 */
@Configuration
@ComponentScan("com.hanovit.app")
@EnableWebMvc
@EnableTransactionManagement
@Import({HibernateConfig.class})
public class ApplicationConfigurer extends WebMvcConfigurerAdapter {
    
}
