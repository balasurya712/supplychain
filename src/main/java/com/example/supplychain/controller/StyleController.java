package com.example.supplychain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supplychain.model.Style;
import com.example.supplychain.service.StyleServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("style")
public class StyleController {

    @Autowired
    private StyleServiceInterface service;
    //write crud operations here
    @GetMapping("/hello")
    public String get() {
        return "Hello World!";
    }

    //create and save the style
    @PostMapping("/save")
    public ResponseEntity<String> insertStyle(@RequestBody Style style) {
        try {
            service.saveData(style);
            return new ResponseEntity<String>( "Inserted Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }
    

    //select all style
    @GetMapping("/select/all")
    public ResponseEntity<List<Style>> selectAll() {
        try {
            return new ResponseEntity<List<Style>>( service.getAllStyle(),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }


    //select style by id;
    @GetMapping("/select/{id}")
    public ResponseEntity<Style> selectById(@PathVariable("id")String id){
        try {
            return new ResponseEntity<Style>( service.getById(id),HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>( null,HttpStatus.BAD_REQUEST);
        }
    }


    //update the style;
    @PutMapping("update")
    public ResponseEntity<String> updateStyle(@RequestBody Style style) {
        try {
            service.updateStyle(style); 
            return new ResponseEntity<String>( "Updated Successfully",HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<String>( "Internal error",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStyle(@PathVariable String id)
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
