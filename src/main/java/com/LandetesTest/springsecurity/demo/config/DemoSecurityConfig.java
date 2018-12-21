package com.LandetesTest.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// añadir usuarios para autenticacion inmemory:
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("jose").password("jose123").roles("EMPLEADO", "MANAGER"));
		auth.inMemoryAuthentication()
				.withUser(users.username("luis").password("luis123").roles("EMPLEADO", "MANAGER", "ADMIN"));
		auth.inMemoryAuthentication().withUser(users.username("jesus").password("jesus123").roles("EMPLEADO"));

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").hasRole("EMPLEADO").antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN").and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/access-denied");

	}

}
