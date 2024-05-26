package com.example.springcloudgateway.java.dto;

public class KafkaResponse {

    private String message;

    public KafkaResponse() {}

    public KafkaResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
