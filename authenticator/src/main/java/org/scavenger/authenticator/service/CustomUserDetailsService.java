package org.scavenger.authenticator.service;

import org.scavenger.authenticator.common.Constants;
import org.scavenger.authenticator.components.CustomAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.core.repositories.auth.UsersRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.core.entities.auth.User userEntity = usersRepository.findUserByUsername(username);
        if (userEntity != null) {
            Set<CustomAuthority> userAuthorities = mapCustomAuthoritiesByUserEntity(userEntity);
            UserDetails userDetails = User.builder()
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword())
                    .accountExpired(userEntity.getAccountExpired())
                    .accountLocked(userEntity.getAccountExpired())
                    .authorities(userAuthorities)
                    .build();
            return userDetails;
        } else {
            throw new UsernameNotFoundException(Constants.USER_NOT_FOUND_MESSAGE);
        }
    }

    private Set<CustomAuthority> mapCustomAuthoritiesByUserEntity(org.core.entities.auth.User user) {
        Set<CustomAuthority> authorities = user.getUserAuthorities().stream()
                .map(ua -> {
                    CustomAuthority customAuthority = new CustomAuthority();
                    customAuthority.setAuthority(ua.getAuthority().getSysName());
                    return customAuthority;
                }).collect(Collectors.toSet());
        CustomAuthority userRole = new CustomAuthority();
        userRole.setAuthority("ROLE_" + user.getUserRole().getSysName());
        authorities.add(userRole);
        return authorities;
    }
}
