package com.example.supplychain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplychain.model.RawMaterial;
import com.example.supplychain.repository.RawMaterialRepository;
import com.example.supplychain.service.RawMaterialServiceInterface;

@Service
public class RawMaterialService implements RawMaterialServiceInterface {
    
    @Autowired
    private RawMaterialRepository repo;

    @Override
    public RawMaterial getById(String id) {
        Optional<RawMaterial> result = repo.findById(id);
        return result.isPresent()?result.get():result.orElse(result.get());
    }

    @Override
    public List<RawMaterial> getAllRawMaterial() {
        return repo.findAll();
    }

    @Override
    public void saveData(RawMaterial rawMaterial) {
        repo.save(rawMaterial);
    }

    @Override
    public void updateData(RawMaterial rawMaterial) {
        repo.save(rawMaterial);
    }

    @Override
    public void deleteData(String id) {
        repo.deleteById(id);
    }

    
}
