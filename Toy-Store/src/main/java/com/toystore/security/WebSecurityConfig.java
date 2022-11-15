package com.toystore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/customer/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/customer").hasRole("USER")
				.antMatchers(HttpMethod.PUT, "/api/customer").hasRole("USER") //.roles("USER","ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/customer/**").hasRole("ADMIN")				
			.anyRequest().authenticated() //.permitAll()
			.and()
			.csrf().disable();							
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("hilario")
			.password("{noop}solovino")
			.roles("ADMIN")
			.and()
			.withUser("chispa")
			.password("{noop}suprema")
			.roles("USER");
	
	}
	
}
