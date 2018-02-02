package com.xcactus.framework.module.users.configs;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author mateusz.kostrzeba
 *
 */
public class AuthenticatedUser extends org.springframework.security.core.userdetails.User {
	
	private static final long serialVersionUID = 3985173103546619138L;
	
	private final User user;
	
	public AuthenticatedUser(User user) {
		super(user.getUsername(),
		    user.getPassword(),
		    true,
		    true,
		    true,
		    true,
		    extractAuthorities());
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	private static Set<GrantedAuthority> extractAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		return authorities;
	}
	
}
