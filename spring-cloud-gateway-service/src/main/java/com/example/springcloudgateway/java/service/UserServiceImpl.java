package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.java.entity.User;
import com.example.springcloudgateway.java.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
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
}
