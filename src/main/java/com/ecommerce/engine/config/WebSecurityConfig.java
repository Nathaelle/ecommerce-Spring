package com.ecommerce.engine.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

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
//	            .defaultSuccessUrl("/perso")
                .successHandler(new AuthentificationLoginSuccessHandler())
//              .failureHandler(new SimpleUrlAuthenticationFailureHandler())
				.permitAll()
				.and()
            .logout()
                .logoutUrl("/logout")
//              .logoutSuccessUrl("/home")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(new AuthenticationLogoutSuccessHandler())
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
	
	private class AuthentificationLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
        	
        	HttpSession session = request.getSession();
        	System.out.println(session.getAttribute("referer"));
        	
        	if(session.getAttribute("referer") != null) {

        		response.sendRedirect((String) request.getSession().getAttribute("referer"));
        		session.removeAttribute("referer");
        		
        	} else {
        		
        		if(request.getHeader("Referer").matches("/login$")) response.sendRedirect(request.getServletContext().getContextPath() + "/perso");
        		else response.sendRedirect(request.getHeader("Referer"));
        		
        	}
        	
	        super.onAuthenticationSuccess(request, response, authentication);
        }
    }


//    private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
//
//        @Override
//        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//    }
	
	
	private class AuthenticationLogoutSuccessHandler extends 
	  SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

	    @Override
	    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
	      throws IOException, ServletException {
	 
	        String refererUrl = request.getHeader("Referer");
	        
	        response.sendRedirect(refererUrl);

	        super.onLogoutSuccess(request, response, authentication);
	    }
	}

    @Bean
    public AuthenticationProvider getProvider() {

        AppAuthProvider provider = new AppAuthProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;

    }
}
