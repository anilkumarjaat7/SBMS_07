package com.p1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	 PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	    @Bean
	     SecurityFilterChain securityFilterChain(HttpSecurity http)
	            throws Exception {

	        http
	            .authorizeHttpRequests(auth -> auth

	                .requestMatchers("/signup", "/login")
	                .permitAll()

	                .requestMatchers("/admin/**")
	                .hasRole("ADMIN")

	                .requestMatchers("/user/**")
	                .hasAnyRole("USER", "ADMIN")

	                .anyRequest()
	                .authenticated()
	            )

	            .formLogin(form -> form

	                .loginPage("/login")

	                .defaultSuccessUrl("/home", true)

	                .permitAll()
	            )

	            .logout(logout -> logout

	                .logoutSuccessUrl("/login?logout")

	                .permitAll()
	            );

	        return http.build();
	    }
}
