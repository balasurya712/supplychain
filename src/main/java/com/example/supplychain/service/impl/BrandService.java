package com.example.supplychain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplychain.model.Brand;
import com.example.supplychain.repository.BrandRepository;
import com.example.supplychain.service.BrandServiceInterface;

@Service
public class BrandService implements BrandServiceInterface{

    @Autowired
    private BrandRepository repo;

    @Override
    public void saveData(Brand brand) {
        repo.save(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        repo.save(brand);
    }

    @Override
    public void deleteData(String id) {
        repo.deleteById(id);
    }

    @Override
    public Brand getById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Brand> getAllBrand() {
        return repo.findAll();
    }

}
