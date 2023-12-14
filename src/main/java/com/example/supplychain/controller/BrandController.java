package com.example.supplychain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> get() {
        return new ResponseEntity<String>("Hello World!",HttpStatus.OK);
    }

    //create and save the Brand
    @PostMapping("/save")
    public ResponseEntity<String> insertBrand(@RequestBody Brand brand) {
        try {
            
            service.saveData(brand);
             return new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>("internal error",HttpStatus.BAD_REQUEST);
        }
    }
    

    //select all Brand
    @GetMapping("/select/all")
    public ResponseEntity<List<Brand>> selectAll() {
        try {
            return new ResponseEntity<List<Brand>>(service.getAllBrand(),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    //select Brand by id;
    @GetMapping("/select/{id}")
    public ResponseEntity<Brand> selectById(@PathVariable("id")String id){
        try {
            return new ResponseEntity<Brand>(service.getById(id),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    //update the Brand;
    @PutMapping("update")
    public ResponseEntity<String> updateBrand(@RequestBody Brand brand) {
        try {
            service.updateBrand(brand); 
            return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
             return new ResponseEntity<String>("Internal error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable String id)
    {
        try {
            if(service.getById(id)==null)
            service.deleteData(id);
            else return new ResponseEntity<String>("Id not found",HttpStatus.OK);
            return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>("Internal error",HttpStatus.BAD_REQUEST);
        }
    }
}
