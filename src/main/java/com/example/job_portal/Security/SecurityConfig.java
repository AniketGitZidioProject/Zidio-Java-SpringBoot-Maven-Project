package com.example.job_portal.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.authorizeHttpRequests(auth -> auth
				.antMatchers("/api/auth/**",
						"/api/employees/**",
						"/api/recruiters/**",
						"/api/jobPosts/**",
						"/api/applications/**",
						"/api/admins/**",
						"/api/notifications/**",
						"/api/analytic/**",
						"/api/email/**",
						"/api/uploadFiles/**", 
						"/api/auditLogs/**",
						"/api/Dashboard/**",
						"/api/paidsubscriptions/**"
						).permitAll()

				.anyRequest().authenticated()
				)
		.csrf(csrf -> csrf.disable())//new lambda style
		.httpBasic(Customizer.withDefaults()); //new style
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration config)throws Exception {
		return config.getAuthenticationManager();
		
	}

}




