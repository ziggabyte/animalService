package com.example.animalservice;

import lombok.Value;

import java.util.UUID;

@Value
public class Animal {
    String id;
    String name;
    String binomialName;
    String description;
    String conservationStatus;

    public Animal(String name, String binomialName, String description, String conservationStatus) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.binomialName = binomialName;
        this.description = description;
        this.conservationStatus = conservationStatus;
    }
}
