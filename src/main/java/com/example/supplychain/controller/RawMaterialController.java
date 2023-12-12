package com.example.supplychain.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain.model.RawMaterial;
import com.example.supplychain.service.RawMaterialServiceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping(path = "/rawmaterial")
public class RawMaterialController {

    @Autowired
    private RawMaterialServiceInterface service;

       //write crud operations here
    @GetMapping("/hello")
    public String get() {
        return "Hello World!";
    }

    //create and save the RawMaterial
    @PostMapping("/save")
    public String insertSupplier(@RequestBody RawMaterial rawMaterial) {
        System.out.println(rawMaterial);
        service.saveData(rawMaterial);
        return "Inserted Successfully";
    }
    

    //select all Supplier
    @GetMapping("/select/all")
    public List<RawMaterial> selectAll() {
        return service.getAllRawMaterial();
    }


    //select RawMaterial by id;
    @GetMapping("/select/{id}")
    public RawMaterial selectById(@PathVariable("id")String id){
        return service.getById(id);
    }


    //update the RawMaterial;
    @PutMapping("update")
    public String updateSupplier(@RequestBody RawMaterial rawMaterial) {
        service.updateData(rawMaterial); 
        return "Updated Successfully";
    }

    @DeleteMapping("delete/{id}")
    public String deleteSupplier(@PathVariable String id)
    {
        service.deleteData(id);
        return "Deleted Successfully";
    }

}
