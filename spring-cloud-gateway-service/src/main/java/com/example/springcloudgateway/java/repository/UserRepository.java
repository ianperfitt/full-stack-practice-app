package com.example.springcloudgateway.java.repository;

import com.example.springcloudgateway.java.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
