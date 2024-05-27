package com.example.javapracticemicroservice.repository;

import com.example.javapracticemicroservice.service.JavaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class JavaRepositoryImpl implements JavaRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaServiceImpl.class);

    @Override
    public String response() {

        LOGGER.info(String.format("JavaRepositoryImpl -> Returning 'autowired' for appending in calling service"));

        return "autowired";
    }

    @Override
    public String helloWorld() {
        return "hello world java";
    }
}
