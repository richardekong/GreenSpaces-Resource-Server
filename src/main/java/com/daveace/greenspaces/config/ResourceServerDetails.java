package com.daveace.greenspaces.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "greenspaces.resource-server-details")
@Getter
@Setter
public class ResourceServerDetails {

    private String keySetUri;
    private String introspectionUri;
    private String clientID;
    private String secret;


}
