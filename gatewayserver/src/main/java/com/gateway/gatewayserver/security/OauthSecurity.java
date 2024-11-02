package com.gateway.gatewayserver.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class OauthSecurity {

    @Bean
    public SecurityWebFilterChain allow(ServerHttpSecurity severHttpWebSecurity)
    {
        severHttpWebSecurity.authorizeExchange(exchange-> exchange.pathMatchers(HttpMethod.GET).permitAll()
                .pathMatchers("/DEPARTMENT-MS/**").authenticated()).oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec.jwt(Customizer.withDefaults()));

        severHttpWebSecurity.csrf(csrfSpec -> csrfSpec.disable());
        return severHttpWebSecurity.build();

    }

}
