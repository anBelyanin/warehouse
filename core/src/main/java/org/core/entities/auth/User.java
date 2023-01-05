package org.core.entities.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(schema = "authenticator", name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    @SequenceGenerator(name = "users_sequence", sequenceName = "users_sequence", allocationSize = 10)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "active_token")
    private String activeToken;

    @Column(name = "token_expiration_time")
    private LocalDateTime tokenExpirationTime;

    @Column(name = "account_expired")
    private Boolean accountExpired;

    @JoinColumn(name = "user_role_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Role userRole;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
    private Set<UserAuthority> userAuthorities;

}
