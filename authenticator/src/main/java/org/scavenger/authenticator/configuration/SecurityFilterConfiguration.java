package org.scavenger.authenticator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ChangeSessionIdAuthenticationStrategy;

@Configuration("securityFilterConfiguration")
public class SecurityFilterConfiguration {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http,
                                               AuthenticationByRequestProcessingFilter filter) throws Exception {
        http
                .csrf().disable()
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .sessionAuthenticationStrategy(new ChangeSessionIdAuthenticationStrategy())
                        .sessionFixation().newSession()
                        .maximumSessions(2))
                .addFilterAt(filter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests((r) -> r
                .requestMatchers("/health").hasRole("SERVICE")
                .requestMatchers("/authenticate").permitAll()
                .anyRequest().authenticated()
                )
                .logout(logout -> logout.logoutUrl("/logout"));

        http.formLogin().disable();

        return http.build();
    }
}
