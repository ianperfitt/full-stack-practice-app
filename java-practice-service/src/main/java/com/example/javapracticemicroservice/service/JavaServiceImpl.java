package com.example.javapracticemicroservice.service;

import com.example.javapracticemicroservice.repository.JavaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaServiceImpl implements JavaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaServiceImpl.class);

    private JavaRepository javaRepositoryConstructor;

    private JavaRepository javaRepositorySetter;

    // field injection
    @Autowired
    private JavaRepository javaRepositoryField;

    // constructor injection
    @Autowired
    JavaServiceImpl(JavaRepository javaRepositoryConstructor) {

        this.javaRepositoryConstructor = javaRepositoryConstructor;
    }

    // setter injection
    @Autowired
    public void setJavaService(JavaRepository javaRepositorySetter) {

        this.javaRepositorySetter = javaRepositorySetter;
    }

    public String response() {

        LOGGER.info(String.format("JavaServiceImpl -> Constructing responses using constructor, setter & field injection"));

        String constructorResponse = javaRepositoryConstructor.response();
        String setterResponse = javaRepositorySetter.response();
        String fieldResponse = javaRepositoryField.response();
        constructorResponse = constructorResponse + " using constructor injection!";
        setterResponse = setterResponse + " using setter injection!";
        fieldResponse = fieldResponse + " using field injection!";
        StringBuilder sb = new StringBuilder();
        sb.append(constructorResponse);
        sb.append("\n");
        sb.append(setterResponse);
        sb.append("\n");
        sb.append(fieldResponse);

        return sb.toString();
    }

    @Override
    public String helloWorld() {
        return javaRepositoryField.helloWorld();
    }
}
