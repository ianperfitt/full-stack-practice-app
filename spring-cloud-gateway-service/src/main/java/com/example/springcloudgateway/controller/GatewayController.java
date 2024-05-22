package com.example.springcloudgateway.controller;

import com.example.springcloudgateway.config.UriConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayController {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {
        String javaHttpUri = uriConfiguration.getJavaPath();
        return builder.routes()
                .route("java_path_route", r -> r.path("/helloworld")
                        .uri(javaHttpUri))
                // used for fallback forwarding example
                .route(p -> p
                        .host("*.circuitbreaker.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri("http://httpbin.org:80"))
                .build();
    }
}
