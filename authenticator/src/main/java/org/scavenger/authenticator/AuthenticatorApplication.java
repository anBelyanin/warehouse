package org.scavenger.authenticator;

import org.scavenger.authenticator.common.configuration.SecuringAppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "org.core.entities.auth")
@EnableJpaRepositories(basePackages = "org.core.repositories.auth")
@EnableConfigurationProperties(SecuringAppConfiguration.class)
public class AuthenticatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticatorApplication.class, args);
    }
}
