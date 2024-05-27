package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.java.dto.RestTemplateDto;
import com.example.springcloudgateway.java.entity.User;
import com.example.springcloudgateway.java.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    private RestTemplate restTemplate;

    @Autowired
    UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {

        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User createUser(User u) {

        return userRepository.save(u);
    }

    @Override
    public void deleteUser() {

        LOGGER.info(String.format("UserServiceImpl -> About to delete Ian. This will be done by modifying the UserRepository Transactional settings to set readOnly = false and deleting via custom SQL query"));

        userRepository.deleteUser();
    }

    @Override
    public RestTemplateDto resttemplate() {

        LOGGER.info(String.format("UserServiceImpl -> About to make API call using REST Template"));

        ResponseEntity<RestTemplateDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8081/java/resttemplate",
                        RestTemplateDto.class);

        RestTemplateDto restTemplateDto = responseEntity.getBody();
        return restTemplateDto;
    }

    @Override
    public RestTemplateDto resttemplateExchange() {

        LOGGER.info(String.format("UserServiceImpl -> About to make API call using REST Template Exchange"));

        ResponseEntity<RestTemplateDto> responseEntity = restTemplate
                .exchange("http://localhost:8081/java/rest-template-exchange", HttpMethod.GET,null, RestTemplateDto.class);

        RestTemplateDto restTemplateDto = responseEntity.getBody();
        return restTemplateDto;
    }
}