package com.example.javapracticemicroservice.service;

import com.example.javapracticemicroservice.repository.JavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JavaServiceImpl implements JavaService {

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
}
