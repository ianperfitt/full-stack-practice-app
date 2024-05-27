package com.example.springcloudgateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public
class UriConfiguration {

    private String javaPath = "http://localhost:8080/java";

    private String angularPath = "http://localhost:8080/angular";

    private String sqlPath = "http://localhost:8080/sql";

    public String getJavaPath() {

        return javaPath;
    }

    public void setJavaPath(String javaPath) {

        this.javaPath = javaPath;
    }

    public String getAngularPath() {

        return angularPath;
    }

    public void setAngularPath(String angularPath) {

        this.angularPath = angularPath;
    }

    public String getSqlPath() {

        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {

        this.sqlPath = sqlPath;
    }
}
