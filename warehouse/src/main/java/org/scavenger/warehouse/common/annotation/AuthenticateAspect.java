package org.scavenger.warehouse.common.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.core.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Aspect
@Component("authenticateAspect")
public class AuthenticateAspect {

    private final RestTemplate restTemplate;

    @Value("${authenticator.url}")
    private String authenticatorUrl;

    public AuthenticateAspect() {
        this.restTemplate = new RestTemplate();
    }

    @Around("@annotation(Authenticate)")
    public Object authenticate(ProceedingJoinPoint joinPoint) throws Throwable {
        if (authenticatorUrl == null) {
            throw new BusinessException("Authenticator url not configured");
        }
        //TODO create auth checking from rest client, this is temp solution
        return "redirect:" + authenticatorUrl;
    }
}
