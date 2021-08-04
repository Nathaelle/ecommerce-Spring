package com.ecommerce.engine.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
public class User implements Serializable , UserDetails {

	// serialVersionUID Auto-généré
	private static final long serialVersionUID = 4081416101898647831L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique=true)
	private String username;

	@Column(nullable=false)
	private String password;
	
	@Column(unique=true)
	private String email;
	
	@Column(nullable=false)
	private String role;

	public Integer getId() {
	   return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
	   return false;
	}

	@Override
	public boolean isAccountNonLocked() {
	   return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getRole() {
	    return role;
	}

	public void setRole(String role) {
	    this.role = role;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
