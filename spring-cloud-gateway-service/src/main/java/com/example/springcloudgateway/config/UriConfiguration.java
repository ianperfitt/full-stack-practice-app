package com.example.springcloudgateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public
class UriConfiguration {

    private String javaPath = "http://localhost:8080/java";

    public String getJavaPath() {

        return javaPath;
    }

    public void setJavaPath(String javaPath) {

        this.javaPath = javaPath;
    }
}
