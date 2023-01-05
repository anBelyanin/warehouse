package org.core.entities.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "authenticator", name = "users_authorities")
public class UserAuthority {

    @Id
    private Long id;

    @JoinColumn(name = "authority_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Authority authority;

    @Column(name = "user_id")
    private Long userId;

}
