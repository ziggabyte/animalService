package com.example.animalservice;

import lombok.Value;

@Value
public class AnimalDTO {
    String id;
    String name;
    String binomialName;
    String description;
    String conservationStatus;

    public AnimalDTO(String id, String name, String binomialName, String description, String conservationStatus) {
        this.id = id;
        this.name = name;
        this.binomialName = binomialName;
        this.description = description;
        this.conservationStatus = conservationStatus;
    }
}
