package org.scavenger.warehouse.common.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.core.exceptions.BusinessException;
import org.core.pojo.api.AuthRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.engine.TemplateData;

import java.util.Map;


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
        AuthRequest authRequest = new AuthRequest();
        return null;
    }
}
