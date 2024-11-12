package com.leon.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.leon.api.filter.JwtAuthFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
			.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/login").permitAll();
			auth.requestMatchers("/employees").hasRole("USER");
			auth.requestMatchers("/employee/**").hasRole("ADMIN");
			auth.anyRequest().authenticated();
		}).addFilterBefore(new JwtAuthFilter(users()), UsernamePasswordAuthenticationFilter.class)
			.httpBasic(Customizer.withDefaults())
			.build();
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user@user.com")
				.password(passwordEncoder().encode("user"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder().username("admin@admin.com").
				password(passwordEncoder().encode("admin"))
				.roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	} 

}
