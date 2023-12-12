package com.example.supplychain.service;

import java.util.List;

import com.example.supplychain.model.RawMaterial;

public interface RawMaterialServiceInterface {

    
    RawMaterial getById(String id);
    
    List<RawMaterial> getAllRawMaterial();
    
    void saveData(RawMaterial rawMaterial);
    
    void updateData(RawMaterial rawMaterial);
    
    void deleteData(String id);

}
