package com.example.supplychain.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain.model.RawMaterial;
import com.example.supplychain.service.RawMaterialServiceInterface;

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
    public ResponseEntity<String> insertSupplier(@RequestBody RawMaterial rawMaterial) {
        try {
            service.saveData(rawMaterial);
            return new ResponseEntity<String>( "Inserted Successfully",HttpStatus.OK); 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }
    

    //select all Supplier
    @GetMapping("/select/all")
    public ResponseEntity<List<RawMaterial>> selectAll() {
        try {
            return  new ResponseEntity<List<RawMaterial>>( service.getAllRawMaterial(),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }


    //select RawMaterial by id;
    @GetMapping("/select/{id}")
    public ResponseEntity<RawMaterial> selectById(@PathVariable("id")String id){
        try {
            return new ResponseEntity<RawMaterial>( service.getById(id),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }


    //update the RawMaterial;
    @PutMapping("update")
    public ResponseEntity<String> updateSupplier(@RequestBody RawMaterial rawMaterial) {
        try {
            service.updateData(rawMaterial); 
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
            return new ResponseEntity<String>( "Deleted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }

}
