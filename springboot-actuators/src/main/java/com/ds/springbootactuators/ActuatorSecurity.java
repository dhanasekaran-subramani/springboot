package com.ds.springbootactuators;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ActuatorSecurity extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//log.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");

		/*
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
			.httpBasic();
	
		 */
		http
        .authorizeRequests()
        .antMatchers("/actuator/info", "/actuator/health").permitAll()
        .antMatchers("/actuator/**").authenticated()
        .and().httpBasic().and().csrf().disable();
	}
	

}
