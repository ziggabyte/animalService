package com.example.animalservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {
    AnimalRepository animalRepository;

    public List<AnimalEntity> all() {
        return animalRepository.all();
    }

    public AnimalEntity add(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(name, binomialName, null, null);
        return animalRepository.save(animalEntity);
    }

    public AnimalEntity get(String id) {
        return animalRepository.get(id);
    }

    public AnimalEntity update(String id, String name, String binomialName) {
        AnimalEntity animalEntity = get(id);
        animalEntity.setName(name);
        animalEntity.setBinomialName(binomialName);
        return animalRepository.save(animalEntity);
    }

    public void delete(String id) {
        animalRepository.delete(get(id));
    }
}
