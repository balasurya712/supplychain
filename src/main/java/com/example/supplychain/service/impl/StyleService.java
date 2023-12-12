package com.example.supplychain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supplychain.model.Style;
import com.example.supplychain.repository.StyleRepository;
import com.example.supplychain.service.StyleServiceInterface;

@Service
public class StyleService implements StyleServiceInterface{

    @Autowired
    private StyleRepository repo;

    @Override
    public List<Style> getAllStyle() {
        return repo.findAll();
    }

    @Override
    public Style getById(String id) {
       Optional<Style> result = repo.findById(id);
      return result.isPresent()?result.get():result.orElse(result.get());
    }

    @Override
    public void saveData(Style style) {
       repo.save(style);
    }

    @Override
    public void updateStyle(Style style) {
        repo.save(style);
    }

    @Override
    public void deleteData(String id) {
        repo.deleteById(id);
    }


}
