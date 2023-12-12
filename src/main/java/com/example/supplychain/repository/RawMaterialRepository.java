package com.example.supplychain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.supplychain.model.RawMaterial;

@Repository
public interface RawMaterialRepository extends MongoRepository<RawMaterial,String>{

}
