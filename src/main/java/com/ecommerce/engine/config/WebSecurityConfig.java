package com.ecommerce.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ecommerce.engine.authentication.AppAuthProvider;
import com.ecommerce.engine.authentication.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    UserService userDetailsService;
	
	/**
	 * {@link https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-form}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/", "/home", "/category-*", "/admin*", "/admin-cat-*", "/admin-it-*").permitAll()
				.antMatchers(HttpMethod.POST, "/category/*", "/item/*", "/user/*").permitAll()
				.antMatchers("/css/**").permitAll()
				//.antMatchers("/perso*").hasRole("USER")
				//.antMatchers("/admin*").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.authenticationProvider(getProvider())
			.formLogin()
				.loginPage("/login")
	            .defaultSuccessUrl("/perso")
//                .successHandler(new AuthentificationLoginSuccessHandler())
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.permitAll()
				.and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSESSIONID")
//                .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .permitAll();
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
	
	/**
	 * {@link https://docs.spring.io/spring-security/site/docs/current/reference/html5/#authentication-password-storage-bcrypt}
	 * @return
	 */
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
    @Bean
    public AuthenticationProvider getProvider() {

        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;

    }
}
