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

import com.example.supplychain.model.Brand;
import com.example.supplychain.service.BrandServiceInterface;

@RestController
@RequestMapping(path="brand")
public class BrandController {

    @Autowired
    private BrandServiceInterface service;

    //write crud operations here
    @GetMapping("/hello")
    public String get() {
        return "Hello World!";
    }

    //create and save the Brand
    @PostMapping("/save")
    public String insertBrand(@RequestBody Brand brand) {
        service.saveData(brand);
        return "Inserted Successfully";
    }
    

    //select all Brand
    @GetMapping("/select/all")
    public List<Brand> selectAll() {
        return service.getAllBrand();
    }


    //select Brand by id;
    @GetMapping("/select/{id}")
    public Brand selectById(@PathVariable("id")String id){
        return service.getById(id);
    }


    //update the Brand;
    @PutMapping("update")
    public String updateBrand(@RequestBody Brand brand) {
        service.updateBrand(brand); 
        return "Updated Successfully";
    }

    @DeleteMapping("delete/{id}")
    public String deleteBrand(@PathVariable String id)
    {
        service.deleteData(id);
        return "Deleted Successfully";
    }
}
