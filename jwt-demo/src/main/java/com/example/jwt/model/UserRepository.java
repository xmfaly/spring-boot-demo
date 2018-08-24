package com.example.jwt.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    User findByUsername(String username);
}
