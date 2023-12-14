package com.example.supplychain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain.model.Supplier;
import com.example.supplychain.service.SupplierServiceInterface;


@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    private SupplierServiceInterface service;

      //write crud operations here
    @GetMapping("/hello")
    public String get() {
        return "Hello World!";
    }

    //create and save the Supplier
    @PostMapping("/save")
    public ResponseEntity<String> insertSupplier(@RequestBody Supplier supplier) {
        try {
            service.saveData(supplier);
            return new ResponseEntity<String>("Inserted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>("Internal error",HttpStatus.BAD_REQUEST);
        }
    }
    

    //select all Supplier
    @GetMapping("/select/all")
    public ResponseEntity<List<Supplier>> selectAll() {
        try {
            return new ResponseEntity<List<Supplier>>( service.getAllSupplier(),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }


    //select Supplier by id;
    @GetMapping("/select/{id}")
    public ResponseEntity<Supplier> selectById(@PathVariable("id")String id){
        try {
            return new ResponseEntity<Supplier>( service.getById(id),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }


    //update the Supplier;
    @PutMapping("update")
    public ResponseEntity<String> updateSupplier(@RequestBody Supplier supplier) {
        try {
            service.updateData(supplier); 
            return new ResponseEntity<String>( "Updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String id)
    {
        try {
            if(service.getById(id)==null)
            service.deleteData(id);
            else return new ResponseEntity<String>( "Id not found",HttpStatus.NOT_FOUND);
            return  new ResponseEntity<String>( "Deleted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
           return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }
}
