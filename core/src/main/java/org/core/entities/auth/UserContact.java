package org.core.entities.auth;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Table(schema = "authenticator", name = "user_contact")
@Getter
@Setter
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_contact_sequence")
    @SequenceGenerator(name = "user_contact_sequence", sequenceName = "user_contact_sequence", allocationSize = 10)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contact_type_id")
    private ContactType contactType;

    @Column(name = "value")
    private String value;
}
