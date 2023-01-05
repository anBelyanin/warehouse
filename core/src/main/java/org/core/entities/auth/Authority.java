package org.core.entities.auth;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "authenticator", name = "core_authorities")
public class Authority {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "sysname")
    private String sysName;

    @Column(name = "description")
    private String description;

}
