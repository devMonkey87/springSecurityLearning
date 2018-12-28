package com.LandetesTest.springsecurity.demo.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.LandetesTest")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// variables que contendran propiedades

	@Autowired
	private Environment env;

	// añadido Logger:

	private Logger logger = Logger.getLogger(getClass().getName());

	// este bean es equivalente a cuando haciamos en xml el :

	/*
	 * <bean
	 * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * <property name= "prefix" value = ""/WEB-INF/view/"/> * <property name=
	 * "suffix" value = ".jsp"/>
	 * 
	 */
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// bean para el Datasource

	@Bean
	public DataSource securityDataSource() {

		return null;

	}
}
