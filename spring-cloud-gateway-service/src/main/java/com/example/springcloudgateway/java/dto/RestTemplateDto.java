package com.example.springcloudgateway.java.dto;

public class RestTemplateDto {

    private String message;

    public RestTemplateDto() {}

    public RestTemplateDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
