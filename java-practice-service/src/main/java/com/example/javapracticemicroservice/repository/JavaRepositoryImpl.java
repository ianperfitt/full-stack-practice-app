package com.example.javapracticemicroservice.repository;

import org.springframework.stereotype.Repository;

@Repository
public class JavaRepositoryImpl implements JavaRepository{

    @Override
    public String response() {

        return "autowired";
    }
}
