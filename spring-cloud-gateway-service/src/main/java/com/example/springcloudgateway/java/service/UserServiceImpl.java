package com.example.springcloudgateway.java.service;

import com.example.springcloudgateway.java.entity.User;
import com.example.springcloudgateway.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User u) {

        return userRepository.save(u);
    }
}
