package com.example.animalservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    ArrayList<Animal> animals;
    public AnimalController() {
        animals = new ArrayList<>();
        animals.add(new Animal("Lejon", "Kattis katt", null, null));
        animals.add(new Animal("Struts", "Långis långis", null, null));
    }

    @GetMapping
    public List<Animal> all() {
        return animals;
    }

    @PostMapping("/create")
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal) {
        Animal animal = new Animal(createAnimal.getName(), createAnimal.getBinomialName(), null, null);
        animals.add(animal);
        return animal;
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return animals.stream()
                .filter(animal -> animal.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) {
        Animal animal = new Animal(updateAnimal.getName(), updateAnimal.getBinomialName(), null, null);
        animals.removeIf(a -> a.getId().equals(id));
        animals.add(animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        System.out.println("Nu är jag här med id " + id);
        animals.removeIf(animal -> animal.getId().equals(id));
    }
}
