package com.hotelreservationsystem.hrs.services.impl;

import com.hotelreservationsystem.hrs.models.Hotel;
import com.hotelreservationsystem.hrs.services.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoServiceImpl implements MongoService{
    private final MongoTemplate mongoTemplate;


    @Autowired
    public MongoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

    @Override
    public <T> T save(T entity, String collectionName) {
        return mongoTemplate.save(entity,collectionName);
    }



    @Override
    public <T> List<T> find(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query, entityClass);
    }

    @Override
    public <T> T findOne(Query query, Class<T> entityClass) {
        return mongoTemplate.findOne(query, entityClass);
    }
}

