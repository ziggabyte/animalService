package com.example.animalservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    ArrayList<AnimalEntity> animals;

    public AnimalService() {
        animals = new ArrayList<>();
        animals.add(new AnimalEntity(null, "Lejon", "Kattis katt", null, null));
        animals.add(new AnimalEntity(null, "Struts", "Långis långis", null, null));
    }

    public List<AnimalEntity> all() {
        return animals;
    }

    public AnimalEntity add(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(null, name, binomialName, null, null);
        animals.add(animalEntity);
        return animalEntity;
    }

    public AnimalEntity get(String id) {
        return animals.stream()
                .filter(animal -> animal.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public AnimalEntity update(String id, String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(null, name, binomialName, null, null);
        animals.removeIf(a -> a.getId().equals(id));
        animals.add(animalEntity);
        return animalEntity;
    }

    public void delete(String id) {
        animals.removeIf(animal -> animal.getId().equals(id));
    }
}
