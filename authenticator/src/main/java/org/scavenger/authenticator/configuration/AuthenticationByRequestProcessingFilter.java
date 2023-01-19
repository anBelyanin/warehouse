package org.scavenger.authenticator.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.core.pojo.api.AuthRequest;
import org.scavenger.authenticator.common.Constants;
import org.scavenger.authenticator.components.AuthEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.io.IOException;

@Configuration("authenticationProcessingFilter")
public class AuthenticationByRequestProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AuthenticationByRequestProcessingFilter(AuthenticationManager authenticationManager,
                                                   UserDetailsService userDetailsService,
                                                   PasswordEncoder passwordEncoder,
                                                   AuthEventHandler authenticationEventHandler) {
        super("/authenticate/{?}", authenticationManager);
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.setAuthenticationSuccessHandler(authenticationEventHandler);
        this.setAuthenticationFailureHandler(authenticationEventHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        AuthRequest authRequest = new ObjectMapper().readValue(request.getInputStream(), AuthRequest.class);
        logger.info(request.getSession(true).getId());
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getLogin());
        UsernamePasswordAuthenticationToken token;
        if (userDetails != null) {
            token = new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword(), userDetails.getAuthorities());
            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        } else {
            throw new UsernameNotFoundException(Constants.USER_NOT_FOUND_MESSAGE);
        }
        return this.getAuthenticationManager().authenticate(token);
    }


}
