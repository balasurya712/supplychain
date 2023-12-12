package com.example.supplychain.service;

import java.util.List;

import com.example.supplychain.model.Supplier;

public interface SupplierServiceInterface {

    Supplier getById(String id);

    List<Supplier> getAllSupplier();

    void saveData(Supplier supplier);

    void updateData(Supplier supplier);

    void deleteData(String id);

}
