package com.example.animalservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class AnimalDTO {
    String id;
    String name;
    String binomialName;
    String description;
    String conservationStatus;

    @JsonCreator
    public AnimalDTO(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("binomialName") String binomialName,
            @JsonProperty("description") String description,
            @JsonProperty("conservationStatus") String conservationStatus) {
        this.id = id;
        this.name = name;
        this.binomialName = binomialName;
        this.description = description;
        this.conservationStatus = conservationStatus;
    }

}
