package com.xcactus.framework.module.users.configs;

import java.util.HashSet;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author mateusz.kostrzeba
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User(username, "admin", false, false, false, false, new HashSet<>());
		return new AuthenticatedUser(user);
	}
}
