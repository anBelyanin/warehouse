package org.scavenger.authenticator.controllers;

import org.scavenger.authenticator.common.Constants;
import org.scavenger.authenticator.common.configuration.SecuringAppConfiguration;
import org.scavenger.authenticator.common.pojo.api.AuthRequest;
import org.scavenger.authenticator.common.pojo.api.AuthResponse;
import org.scavenger.authenticator.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    AuthService authService;
    SecuringAppConfiguration securingAppConfiguration;

    @Autowired
    public AuthController(AuthService authService,
                          SecuringAppConfiguration securingAppConfiguration) {
        this.authService = authService;
        this.securingAppConfiguration = securingAppConfiguration;
    }

    @PostMapping(path = "authenticate")
    public AuthResponse authenticate(AuthRequest request) {
        AuthResponse authResponse = new AuthResponse();
        if (authService.isAuthenticated()) {
            authResponse.setStatus(Constants.AUTH_SUCCESS_RESULT);
            authResponse.setMessage(Constants.AUTH_SUCCESS_RESULT);
        } else {
            authResponse.setMessage(Constants.USER_NOT_FOUND_MESSAGE);
            authResponse.setStatus(Constants.AUTH_UNSUCCESS_RESULT);
        }
        return authResponse;
    }

    @GetMapping(path = {"/", "/auth-process"})
    public String getAuthentication(@RequestParam String redirectUrl) {
        if (authService.isAuthenticated()) {
            return "redirect:" + redirectUrl;
        }
        else return "login-form";
    }

    @GetMapping(path = {"/logout"})
    public String getLogout() {
        if (authService.isAuthenticated()) {
            authService.logout(SecurityContextHolder.getContext().getAuthentication());
            return "redirect:/auth-process?logout";
        } else return "redirect:/auth-process";
    }

    @GetMapping(path = "/access-denied")
    public String getAccessDeniedPage() {
        if (authService.isAuthenticated()) {
            return "access-denied-page";
        } else return "redirect:/auth-process";
    }
}
