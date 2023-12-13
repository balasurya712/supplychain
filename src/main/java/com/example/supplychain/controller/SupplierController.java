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
    public String insertSupplier(@RequestBody Supplier supplier) {
        try {
            service.saveData(supplier);
            return "Inserted Successfully";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Internal error";
        }
    }
    

    //select all Supplier
    @GetMapping("/select/all")
    public List<Supplier> selectAll() {
        try {
            return service.getAllSupplier();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    //select Supplier by id;
    @GetMapping("/select/{id}")
    public Supplier selectById(@PathVariable("id")String id){
        try {
            return service.getById(id);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    //update the Supplier;
    @PutMapping("update")
    public String updateSupplier(@RequestBody Supplier supplier) {
        try {
            service.updateData(supplier); 
            return "Updated Successfully";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Internal error";
        }
    }

    @DeleteMapping("delete/{id}")
    public String deleteSupplier(@PathVariable String id)
    {
        try {
            if(service.getById(id)==null)
            service.deleteData(id);
            else return "Id not found";
            return "Deleted Successfully";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "Internal error";
        }
    }
}
