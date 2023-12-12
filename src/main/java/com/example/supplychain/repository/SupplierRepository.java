package com.example.supplychain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.supplychain.model.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier,String> {
    
}
