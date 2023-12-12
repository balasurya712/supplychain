package com.example.supplychain.service;

import java.util.List;

import com.example.supplychain.model.Facility;

public interface FacilityServiceInterface {

    void saveData(Facility facility);

    List<Facility> getAllFacility();

    Facility getById(String id);

    void updateFacility(Facility facility);

    void deleteData(String id);


}
