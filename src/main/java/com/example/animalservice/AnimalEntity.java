package com.example.animalservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AnimalEntity {
    String id;
    String name;
    String binomialName;
    String description;
    String conservationStatus;

    public AnimalEntity(String name, String binomialName, String description, String conservationStatus) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.binomialName = binomialName;
        this.description = description;
        this.conservationStatus = conservationStatus;
    }
}
