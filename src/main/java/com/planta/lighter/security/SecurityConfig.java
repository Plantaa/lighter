package com.planta.lighter.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    // @Bean
    // public UserDetailsManager userDetailsManager(DataSource dataSource) {
    //     return new JdbcUserDetailsManager(dataSource);
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/").hasRole("EMPLOYEE")
                .requestMatchers("/leaders/**").hasRole("MANAGER")
                .requestMatchers("/systems/**").hasRole("ADMIN")
                .requestMatchers("/employees/delete").hasRole("ADMIN")
                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyFancyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/showAccessDeniedPage"));

        // http.authorizeHttpRequests(configurer -> configurer
        // .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
        // .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
        // .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
        // .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
        // .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        // .requestMatchers(HttpMethod.GET, "/hello").permitAll()
        // .requestMatchers(HttpMethod.GET, "/").permitAll()
        // );
        // http.httpBasic(Customizer.withDefaults());
        // use HTTP Basic authentication
        // disable Cross Site Request Forgery
        // http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager() {

    // UserDetails john = User.builder()
    // .username("john")
    // .password("{noop}test123")
    // .roles("EMPLOYEE")
    // .build();

    // UserDetails mary = User.builder()
    // .username("mary")
    // .password("{noop}test123")
    // .roles("EMPLOYEE", "MANAGER")
    // .build();

    // UserDetails susan = User.builder()
    // .username("susan")
    // .password("{noop}test123")
    // .roles("EMPLOYEE", "MANAGER", "ADMIN")
    // .build();

    // return new InMemoryUserDetailsManager(john, mary, susan);
    // }
}
