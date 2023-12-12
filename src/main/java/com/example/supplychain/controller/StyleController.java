package com.example.supplychain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String insertStyle(@RequestBody Style style) {
        service.saveData(style);
        return "Inserted Successfully";
    }
    

    //select all style
    @GetMapping("/select/all")
    public List<Style> selectAll() {
        return service.getAllStyle();
    }


    //select style by id;
    @GetMapping("/select/{id}")
    public Style selectById(@PathVariable("id")String id){
        return service.getById(id);
    }


    //update the style;
    @PutMapping("update")
    public String updateStyle(@RequestBody Style style) {
        service.updateStyle(style); 
        return "Updated Successfully";
    }

    @DeleteMapping("delete/{id}")
    public String deleteStyle(@PathVariable String id)
    {
        service.deleteData(id);
        return "Deleted Successfully";
    }



    



        
    }
