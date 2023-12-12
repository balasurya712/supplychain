package com.example.supplychain.service;

import java.util.List;

import com.example.supplychain.model.Brand;

public interface BrandServiceInterface {

    void saveData(Brand brand);

    void updateBrand(Brand brand);

    void deleteData(String id);

    Brand getById(String id);

    List<Brand> getAllBrand();
    
}
