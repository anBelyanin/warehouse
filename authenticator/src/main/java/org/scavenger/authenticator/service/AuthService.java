package org.scavenger.authenticator.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.core.repositories.auth.UsersRepository;
import org.core.entities.auth.User;

@Service
public class AuthService {

    UsersRepository usersRepository;

    public AuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        } else {
            return authentication.isAuthenticated();
        }
    }

    @Transactional
    public void logout(Authentication authentication) {
        authentication.setAuthenticated(Boolean.FALSE);
        User user = usersRepository.findUserByUsername(authentication.getName());
        user.setActiveToken(null);
    }
}