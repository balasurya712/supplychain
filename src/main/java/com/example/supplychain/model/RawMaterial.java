package com.example.supplychain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Document("rawmaterial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterial {

    @Id
    private String _id;
    private String rawMaterialName;
    private String rawMaterialNumber;
    private String rawMaterialUniqueId;
    private String rawMaterialType;
    private ObjectId facilityId;
    private ArrayList<MaterialComposition> materialComposition;
    private ArrayList<String> Certificates;
    private ObjectId brandId;
    private ArrayList<ObjectId> baseMaterialId;

    @Data
    private class MaterialComposition{
        private String material;
        private float percentage;

    }


}

