package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.java.dto.RestTemplateDto;
import com.example.springcloudgateway.java.entity.User;

public interface UserService {

    User createUser(User u);

    void deleteUser();

    RestTemplateDto resttemplate();

    RestTemplateDto resttemplateExchange();
}
