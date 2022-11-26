package com.epam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

	@Autowired
	private AppUserDetailsService userDetailsService;


	@Bean
	public AuthenticationManager getAuthenticationManager() {
		return new ProviderManager(List.of(getAuthenticationProvider()));
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests(autz -> autz.anyRequest().authenticated())
				.authenticationManager(getAuthenticationManager()).formLogin().and()
				.logout(logout -> logout.logoutUrl("/logout")).httpBasic();

		return http.build();
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//
//		users.add(User.withDefaultPasswordEncoder().username("pavan").password("password").roles("USER", "ADMIN")
//				.build());
//		users.add(User.withDefaultPasswordEncoder().username("Divyam").password("password").roles("USER", "ADMIN")
//				.build());
//
//		return new InMemoryUserDetailsManager(users);
//	}

	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		authenticationProvider.setAuthoritiesMapper(getAuthoritiesMapper());

		return authenticationProvider;

	}
	

	@Bean
	public GrantedAuthoritiesMapper getAuthoritiesMapper() {

		SimpleAuthorityMapper authorityMapper = new SimpleAuthorityMapper();
		authorityMapper.setConvertToUpperCase(true);
		authorityMapper.setDefaultAuthority("USER");

		return authorityMapper;
	}

}
