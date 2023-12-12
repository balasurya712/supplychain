package com.example.supplychain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.supplychain.model.Brand;

@Repository
public interface BrandRepository extends MongoRepository<Brand,String>{

}
