package com.superinc.europe.onlineshopping.su.web.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Inheritance;
import javax.sql.DataSource;

import org.apache.catalina.startup.Tomcat;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.SessionFactoryBuilder;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@ContextConfiguration
@Configuration
@EnableWebMvc
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.superinc.europe.onlineshopping.gu, com.superinc.europe.onlineshopping.su"})
//@ImportResource({"classpath*:lessonmvc-servlet.xml", "classpath*:security.xml", "classpath*:localization.xml", "classpath*:beansDao.xml", "classpath*:beansService.xml"})
@ImportResource({"classpath*:lessonmvc-servlet.xml", "classpath*:security.xml", "classpath*:localization.xml"})
@SpringBootApplication(scanBasePackages={"com.superinc.europe.onlineshopping.gu, com.superinc.europe.onlineshopping.su"})
public class SampleController extends WebMvcConfigurerAdapter{

	@Autowired
    private SessionFactory sessionFactory;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
	
	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseRegisteredSuffixPatternMatch(false);
        configurer.setUseSuffixPatternMatch(false);
    }
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

	@Bean  
	public SessionFactory sessionFactory(){
	    return sessionFactory;  
	}  

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	    registry.addResourceHandler("/img/**").addResourceLocations("/img/");
	}
	
}
