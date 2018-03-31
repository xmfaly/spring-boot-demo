package com.example.mongo.dao;

import com.example.mongo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveUser(UserEntity userEntity) {
        mongoTemplate.save(userEntity);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        UserEntity userEntity = mongoTemplate.findOne(query,UserEntity.class);
        return userEntity;
    }

    @Override
    public void updataUser(UserEntity userEntity) {

        Query query = new Query(Criteria.where("username").is(userEntity.getUsername()));
        Update update = new Update().set("password",userEntity.getPassword());
        mongoTemplate.updateFirst(query,update,UserEntity.class);

        // mongoTemplate.updateMulti(query,update,UserEntity.class);

    }

    @Override
    public void deleteUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        mongoTemplate.remove(query,UserEntity.class);
    }
}
