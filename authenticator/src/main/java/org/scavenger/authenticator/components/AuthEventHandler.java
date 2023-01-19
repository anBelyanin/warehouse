package org.scavenger.authenticator.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.core.pojo.api.AuthResponse;
import org.scavenger.authenticator.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component("authenticationEventHandler")
public class AuthEventHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler, LogoutHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (request.getHeader("Content-type").equals("application/json")) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setStatus(Constants.AUTH_SUCCESS_RESULT);
            authResponse.setMessage(Constants.AUTH_SUCCESS_RESULT);
            WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
            logger.info("SessionId: " + details.getSessionId());
            authResponse.setSession(details.getSessionId());
            response.setStatus(HttpServletResponse.SC_OK);
            response.addHeader("Content-type", "application/json");
            PrintWriter writer = response.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(authResponse));
            writer.flush();
        }
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (request.getHeader("Content-type").equals("application/json")) {
            AuthResponse authResponse = new AuthResponse();
            authResponse.setStatus(Constants.AUTH_UNSUCCESSFUL_RESULT);
            authResponse.setMessage(exception.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.addHeader("Content-type", "application/json");
            PrintWriter writer = response.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(authResponse));
            writer.flush();
        }
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        authentication.setAuthenticated(Boolean.FALSE);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
