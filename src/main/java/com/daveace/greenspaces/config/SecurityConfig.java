package com.daveace.greenspaces.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${greenspaces.resource-server-details.clientID}")
    private String clientID;

    @Value("${greenspaces.resource-server-details.secret}")
    private String secret;

    @Value("${greenspaces.resource-server-details.introspectionUri}")
    private String introspectionUri;

    @Value("${greenspaces.resource-server-details.keySetUri}")
    private String keySetUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.oauth2ResourceServer(securityConfigurer ->
                securityConfigurer.jwt(jwtConfigurer -> jwtConfigurer.jwkSetUri(keySetUri)));

        http.authorizeHttpRequests(requestCustomizer -> requestCustomizer.anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public Customizer<OAuth2ResourceServerConfigurer<HttpSecurity>> getoAuth2ResourceServerConfigurerCustomizer() {
        return securityConfigurer ->
                securityConfigurer.opaqueToken(token -> token
                        .introspectionUri(introspectionUri)
                        .introspectionClientCredentials(clientID, secret));
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
