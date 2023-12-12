package com.example.supplychain.service;

import java.util.List;

import com.example.supplychain.model.Style;

public interface StyleServiceInterface {

    List<Style> getAllStyle();

    Style getById(String id);

    void saveData(Style style);

    void updateStyle(Style style);

    void deleteData(String id);

}
