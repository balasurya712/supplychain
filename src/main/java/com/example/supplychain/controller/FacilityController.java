package com.example.supplychain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain.model.Facility;
import com.example.supplychain.service.FacilityServiceInterface;

@RestController
@RequestMapping(path = "/facility")
public class FacilityController {

    @Autowired
    private FacilityServiceInterface service;

     //write crud operations here
    @GetMapping("/hello")
    public String get() {
        return "Hello World!";
    }

    //create and save the Facility
    @PostMapping("/save")
    public String insertFacility(@RequestBody Facility facility) {
        service.saveData(facility);
        return "Inserted Successfully";
    }
    

    //select all Facility
    @GetMapping("/select/all")
    public List<Facility> selectAll() {
        return service.getAllFacility();
    }


    //select Facility by id;
    @GetMapping("/select/{id}")
    public Facility selectById(@PathVariable("id")String id){
        return service.getById(id);
    }


    //update the Facility;
    @PutMapping("update")
    public String updateFacility(@RequestBody Facility facility) {
        service.updateFacility(facility); 
        return "Updated Successfully";
    }

    @DeleteMapping("delete/{id}")
    public String deleteFacility(@PathVariable String id)
    {
        service.deleteData(id);
        return "Deleted Successfully";
    }



}
