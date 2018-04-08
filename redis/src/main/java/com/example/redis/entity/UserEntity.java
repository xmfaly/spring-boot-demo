package com.example.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -1033819643324888625L;

    private String username;
    private int age;
}
