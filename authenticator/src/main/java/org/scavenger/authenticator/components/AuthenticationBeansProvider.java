package org.scavenger.authenticator.components;

import org.core.encoders.password.CustomSha256PasswordEncoder;
import org.core.repositories.auth.UsersRepository;
import org.scavenger.authenticator.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("authenticationBeanProvider")
public class AuthenticationBeansProvider {

    @Bean("userDetailsManager")
    protected UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager detailsManager = new JdbcUserDetailsManager(dataSource);
        return detailsManager;
    }

    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new CustomSha256PasswordEncoder();
    }

    @Bean("authenticationProvider")
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
                                                            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }

    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
        return new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                Authentication resultAuthentication = authenticationProvider.authenticate(authentication);
                SecurityContextHolder.getContext().setAuthentication(resultAuthentication);
                return resultAuthentication;
            }
        };
    }

    @Bean("userDetailsService")
    public UserDetailsService userDetailsService(UsersRepository usersRepository) {
        return new CustomUserDetailsService(usersRepository);
    }

}
