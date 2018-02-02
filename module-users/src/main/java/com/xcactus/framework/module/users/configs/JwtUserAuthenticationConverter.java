package com.xcactus.framework.module.users.configs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.common.util.JsonParser;
import org.springframework.security.oauth2.common.util.JsonParserFactory;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author mateusz.kostrzeba
 *
 */
@Component
public class JwtUserAuthenticationConverter implements UserAuthenticationConverter {
	
	private static final String SUBJECT = "sub";
	private static final String USER = "user";
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	// @Autowired
	// private UserService userService;
	
	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		// AuthenticatedUser authorizedUser = (AuthenticatedUser)
		// authentication.getPrincipal();
		// Optional<User> user =
		// userService.findUserById(authorizedUser.getUser().getId());
		
		Map<String, Object> response = new LinkedHashMap<>();
		// response.put(SUBJECT, authorizedUser.getUser().getEmail());
		// response.put(USER, ConverterUtil.convert(user.get()));
		// if (authentication.getAuthorities() != null &&
		// !authentication.getAuthorities().isEmpty()) {
		// response.put(AUTHORITIES,
		// AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
		// }
		return response;
	}
	
	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		if (map.containsKey(SUBJECT)) {
			Object principal = map.get(SUBJECT);
			Collection<? extends GrantedAuthority> authorities = getAuthorities(map);
			UserDetails user = userDetailsService.loadUserByUsername((String) map.get(SUBJECT));
			authorities = user.getAuthorities();
			principal = user;
			return new UsernamePasswordAuthenticationToken(principal, "N/A", authorities);
		}
		return null;
	}
	
	public Authentication extractAuthentication(String token) {
		JsonParser objectMapper = JsonParserFactory.create();
		Map<String, Object> map = objectMapper.parseMap(JwtHelper.decode(token).getClaims());
		
		UserDetails user = userDetailsService.loadUserByUsername((String) map.get(SUBJECT));
		Object principal = map.get(SUBJECT);
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		principal = user;
		return new UsernamePasswordAuthenticationToken(principal, "N/A", authorities);
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
		if (!map.containsKey(AUTHORITIES)) {
			return new ArrayList<>();
		}
		Object authorities = map.get(AUTHORITIES);
		if (authorities instanceof String) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
		}
		if (authorities instanceof Collection) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
			    .collectionToCommaDelimitedString((Collection<?>) authorities));
		}
		throw new IllegalArgumentException("Authorities must be either a String or a Collection");
	}
}
