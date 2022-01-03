package com.example.animalservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
@AllArgsConstructor
public class AnimalController {

    AnimalService animalService;

    @GetMapping
    public List<Animal> all() {
        return animalService.all()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public Animal createAnimal(@RequestBody CreateAnimal createAnimal) {
        return toDTO(animalService.add(createAnimal.getName(), createAnimal.getBinomialName()));
    }

    @GetMapping("/{id}")
    public Animal get(@PathVariable("id") String id) {
        return toDTO(animalService.get(id));
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) {
        return toDTO(animalService.update(id, updateAnimal.getName(), updateAnimal.getBinomialName()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        animalService.delete(id);
    }

    private Animal toDTO(AnimalEntity animalEntity) {
        return new Animal(
                animalEntity.getName(),
                animalEntity.getBinomialName(),
                animalEntity.getDescription(),
                animalEntity.getConservationStatus()
        );
    }
}
