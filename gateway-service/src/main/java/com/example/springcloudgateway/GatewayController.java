package com.example.springcloudgateway;

import com.example.springcloudgateway.config.UriConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigurationProperties(UriConfiguration.class)
@RestController
public class GatewayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayController.class);

    @Bean
    public org.springframework.cloud.gateway.route.RouteLocator customRouteLocator(RouteLocatorBuilder builder, UriConfiguration uriConfiguration) {

        LOGGER.info(String.format("GatewayController -> Routing request to correct path"));

        String javaHttpUri = uriConfiguration.getJavaPath();
        String angularHttpUri = uriConfiguration.getAngularPath();
        String sqlHttpUri = uriConfiguration.getSqlPath();
        return builder.routes()
                .route("java_path_route", r -> r.path("/*")
                        .uri(javaHttpUri))
                .route("angular_path_route", r -> r.path("/helloworld")
                        .uri(angularHttpUri))
                .route("sql_path_route", r -> r.path("/helloworld")
                        .uri(sqlHttpUri))
                // used for fallback forwarding example
                .route(p -> p
                        .host("*.circuitbreaker.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .host("*.hello.com")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setFallbackUri("forward:/resilience4j-fallback")))
                        .uri("http://httpbin.org:80"))
                .build();
    }
}
