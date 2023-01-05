package org.core.entities.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "authenticator", name = "contact_type")
@Getter
@Setter
public class ContactType {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sysname")
    private String sysName;
}
