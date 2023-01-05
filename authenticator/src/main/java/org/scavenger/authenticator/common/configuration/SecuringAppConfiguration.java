package org.scavenger.authenticator.common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "securing")
public class SecuringAppConfiguration {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String[] servicesUrls;
    private String mainRedirectUrl;

    public String[] getServicesUrls() {
        logger.info(servicesUrls[0]);
        return servicesUrls;
    }

    public String getMainRedirectUrl() {
        logger.info(mainRedirectUrl);
        return mainRedirectUrl;
    }

    public void setServicesUrls(String[] servicesUrls) {
        this.servicesUrls = servicesUrls;
    }

    public void setMainRedirectUrl(String mainRedirectUrl) {
        this.mainRedirectUrl = mainRedirectUrl;
    }
}
