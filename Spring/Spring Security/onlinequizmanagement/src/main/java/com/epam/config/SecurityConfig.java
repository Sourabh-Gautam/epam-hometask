package com.epam.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.epam.service.UserService;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private UserService userService;
	
	@Bean
	public AuthenticationManager getAuthenticationManager() {
		return new ProviderManager(List.of(getAuthenticationProvider()));
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests(auth -> auth.anyRequest().authenticated())
			.authenticationManager(getAuthenticationManager())
			.formLogin()
			.and()
			.logout(logout->logout.logoutUrl("/logout")).httpBasic();
		
		return http.build();
		
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetails() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("admin").build());
//		users.add(User.withDefaultPasswordEncoder().username("student").password("student").roles("student").build());
//		
//		return new InMemoryUserDetailsManager(users);
//	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		authenticationProvider.setAuthoritiesMapper(new SimpleAuthorityMapper());

		return authenticationProvider;

	}
	
}
