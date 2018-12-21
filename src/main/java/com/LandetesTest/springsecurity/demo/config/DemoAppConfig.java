package com.LandetesTest.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.LandetesTest")
public class DemoAppConfig {

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

}
