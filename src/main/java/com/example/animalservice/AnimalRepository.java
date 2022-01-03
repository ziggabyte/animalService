package com.example.animalservice;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalRepository {
    HashMap<String, AnimalEntity> animals;

    public AnimalRepository() {
        this.animals = new HashMap<>();
        AnimalEntity lejon = new AnimalEntity("7e784aed-8eb5-4dea-bd54-9b5bea4e9980", "Lejon", "Kattis katt", null, null);
        AnimalEntity struts = new AnimalEntity("b78cb08a-3d56-4fd2-bdf8-87bdf4231161", "Struts", "Långis långis", null, null);
        animals.put(lejon.getId(), lejon);
        animals.put(struts.getId(), struts);
    }

    public List<AnimalEntity> all() {
        return animals.values().stream().collect(Collectors.toList());
    }

    public AnimalEntity save(AnimalEntity animalEntity) {
        animals.put(animalEntity.getId(), animalEntity);
        return animalEntity;
    }

    public AnimalEntity get(String id) {
        return animals.get(id);
    }

    public void delete(AnimalEntity animalEntity) {
        animals.remove(animalEntity.getId(), animalEntity);
    }
}
