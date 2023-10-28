package com.isc.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
                .username("isc")
                .password("{bcrypt}$2a$12$n9OJ0W/qf6tZ11QOL2gXS.z4tMI1IHR3O5h3lFaj4Yg1AyRjxLTEC")
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();
        return http.build();
    }

    private static final String[] AUTH_WHITELIST = {
            "/swagger-ui**",
            "/swagger-resources/**",
            "/v3/api-docs/**",
            "/webjars/**",
            "/actuator/**",
            "/login",
            "/refresh"
    };
}
