package com.ecommerce.engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	/**
	 * {@link https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-form}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/", "/home", "/category-*", "/admin*", "/admin-cat-*", "/admin-it-*").permitAll()
				.antMatchers(HttpMethod.POST, "/category/*", "/item/*").permitAll()
				.antMatchers("/css/**").permitAll()
				//.antMatchers("/perso*").hasRole("USER")
				//.antMatchers("/admin*").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
            .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .permitAll();
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
          .password("test")
          .roles("USER")
          .and()
          .withUser("admin")
          .password("test")
          .roles("ADMIN");
    }
	
	/**
	 * {@link https://docs.spring.io/spring-security/site/docs/current/reference/html5/#authentication-password-storage-bcrypt}
	 * @return
	 */
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
}
