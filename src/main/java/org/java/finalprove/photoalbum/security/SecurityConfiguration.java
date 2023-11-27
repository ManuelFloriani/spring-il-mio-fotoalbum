package org.java.finalprove.photoalbum.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/photos", "/photos/show/**").hasAuthority("ADMIN")
                .requestMatchers("/users", "/categories", "/messages").hasAuthority("ADMIN")            // Index        USERS-CATEGORIES-MESSAGES
                .requestMatchers("/photos/create").hasAuthority("ADMIN")                                // Create       PHOTO
                .requestMatchers("/photos/edit/**").hasAuthority("ADMIN")                               // Edit         PHOTO
                .requestMatchers("/photos/delete/**", "/categories/delete/**").hasAuthority("ADMIN")    // Delete       PHOTO-CATEGORIES
                .requestMatchers(HttpMethod.POST, "/photos/**", "/categories/**").hasAuthority("ADMIN")
                .requestMatchers("/**").permitAll()
                .and().formLogin()
                .and().logout();
        http.csrf().disable();
        return http.build();
    }

    @Bean
    public DatabaseUserDetailService userDetailsService() {
        return new DatabaseUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
