package com.example.supplychain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.supplychain.model.Style;

@Repository
public interface StyleRepository extends MongoRepository<Style,String> {
    
}
