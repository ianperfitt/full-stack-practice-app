package com.example.javapracticemicroservice.dto;


public class RestTemplateDto {

    private String message;

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
