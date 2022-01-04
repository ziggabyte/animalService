package com.example.animalservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "animal")
public class AnimalEntity {
    @Id
    @SequenceGenerator(
            name = "animal_sequence",
            sequenceName = "animal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "animal_sequence"
    )
    Long id;
    String name;
    String binomialName;
    String description;
    String conservationStatus;

    public AnimalEntity(String name, String binomialName, String description, String conservationStatus) {
        this.name = name;
        this.binomialName = binomialName;
        this.description = description;
        this.conservationStatus = conservationStatus;
    }
}
