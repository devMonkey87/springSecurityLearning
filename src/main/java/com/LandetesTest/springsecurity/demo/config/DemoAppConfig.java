package com.LandetesTest.springsecurity.demo.config;

import java.beans.PropertyVetoException;
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

import com.mchange.v2.c3p0.ComboPooledDataSource;

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

		ComboPooledDataSource securityDSource = new ComboPooledDataSource();

		try {
			securityDSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}

		logger.info(">>>>jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>>>jdbc.user=" + env.getProperty("jdbc.user  "));

		securityDSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDSource.setUser(env.getProperty("jdbc.user"));
		securityDSource.setPassword(env.getProperty("jdbc.password"));

		securityDSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDSource;

	}

	private int getIntProperty(String propName) {
		String propValue = env.getProperty(propName);

		int intPropVal = Integer.parseInt(propValue);

		return intPropVal;
	}
}
