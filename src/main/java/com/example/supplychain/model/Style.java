package com.example.supplychain.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("style")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Style {
   
    private String styleName;
    private String styleNumber;
    private String sytleUniqueId;
    private String styleType;
    private ObjectId supplierId;
    private ObjectId facilityId;
    private String materialComposition;
    private String Certificates;

}
