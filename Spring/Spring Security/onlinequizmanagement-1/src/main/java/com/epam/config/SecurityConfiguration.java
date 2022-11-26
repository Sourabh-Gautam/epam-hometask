package com.epam.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeRequests(autz -> autz.anyRequest().authenticated())
				.formLogin().and()
				.logout(logout -> logout.logoutUrl("/logout")).httpBasic();

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		List<UserDetails> users = new ArrayList<>();

		users.add(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("USER", "ADMIN")
				.build());
		users.add(User.withDefaultPasswordEncoder().username("Divyam").password("password").roles("USER", "ADMIN")
				.build());

		return new InMemoryUserDetailsManager(users);
	}

}
