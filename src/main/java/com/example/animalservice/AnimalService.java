package com.example.animalservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AnimalService {
    AnimalRepository animalRepository;

    public Stream<AnimalEntity> all() {
        return animalRepository.findAll().stream();
    }

    public AnimalEntity add(String name, String binomialName) {
        AnimalEntity animalEntity = new AnimalEntity(name, binomialName, null, null);
        return animalRepository.save(animalEntity);
    }

    public Optional<AnimalEntity> get(String id) throws AnimalMissingException {
        Optional<AnimalEntity> optional = animalRepository.findById(id);
        if (optional.isPresent()) {
            return optional;
        } else {
            throw new AnimalMissingException(id);
        }
    }

    public AnimalEntity update(String id, String name, String binomialName) throws AnimalMissingException {
        Optional<AnimalEntity> optionalAnimalEntity = get(id);
        if (optionalAnimalEntity.isPresent()) {
            optionalAnimalEntity.get().setName(name);
            optionalAnimalEntity.get().setBinomialName(binomialName);
            return animalRepository.save(optionalAnimalEntity.get());
        } else {
            throw new AnimalMissingException(id);
        }
    }

    public void delete(String id) throws AnimalMissingException {
        Optional<AnimalEntity> optionalAnimalEntity = get(id);
        if (optionalAnimalEntity.isPresent()) {
            animalRepository.delete(optionalAnimalEntity.get());
        } else {
            throw new AnimalMissingException(id);
        }
    }
}
