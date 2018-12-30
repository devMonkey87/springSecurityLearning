package com.LandetesTest.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// a�adir usuarios para autenticacion inmemory. Ya no se usa
		// lo haremos con usuarios de BBDD Mysql

//		UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication().withUser(users.username("jose").password("jose123").roles("EMPLEADO", "MANAGER"));
//		auth.inMemoryAuthentication()
//				.withUser(users.username("luis").password("luis123").roles("EMPLEADO", "MANAGER", "ADMIN"));
//		auth.inMemoryAuthentication().withUser(users.username("jesus").password("jesus123").roles("EMPLEADO"));

		// Uso de jdbc authentication

		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN").and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
