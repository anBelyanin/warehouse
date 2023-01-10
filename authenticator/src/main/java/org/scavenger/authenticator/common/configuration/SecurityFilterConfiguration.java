package org.scavenger.authenticator.common.configuration;

import org.core.encoders.password.CustomSha256PasswordEncoder;
import org.scavenger.authenticator.service.AuthService;
import org.scavenger.authenticator.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.core.repositories.auth.CoreRolesRepository;

@Configuration("warehouseSecurityConfiguration")
public class SecurityFilterConfiguration {

    private final CustomUserDetailsService customUserDetailsService;
    private final CoreRolesRepository rolesRepository;
    private final AuthService authService;
    private final SecuringAppConfiguration securingAppConfiguration;

    @Autowired
    public SecurityFilterConfiguration(CustomUserDetailsService customUserDetailsService,
                                       CoreRolesRepository rolesRepository,
                                       AuthService authService, SecuringAppConfiguration securingAppConfiguration) {
        this.customUserDetailsService = customUserDetailsService;
        this.rolesRepository = rolesRepository;
        this.authService = authService;
        this.securingAppConfiguration = securingAppConfiguration;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new CustomSha256PasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((r) -> r
                .requestMatchers("/").authenticated()
                .requestMatchers(securingAppConfiguration.getServicesUrls()).authenticated()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/health-check").hasRole("SERVICE")
                .requestMatchers("/auth-process").permitAll()
                .anyRequest().authenticated()
                )
                .httpBasic()
                .and()
            .authenticationProvider(authProvider())
            .exceptionHandling().accessDeniedPage("/access-denied");

        http.formLogin(f -> f.loginPage("/auth-process"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }

}
