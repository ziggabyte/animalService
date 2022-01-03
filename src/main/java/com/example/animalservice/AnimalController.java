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
    public List<AnimalDTO> all() {
        return animalService.all()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AnimalDTO createAnimal(@RequestBody CreateAnimal createAnimal) {
        return toDTO(animalService.add(createAnimal.getName(), createAnimal.getBinomialName()));
    }

    @GetMapping("/{id}")
    public AnimalDTO get(@PathVariable("id") String id) {
        return toDTO(animalService.get(id));
    }

    @PutMapping("/{id}")
    public AnimalDTO update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal) {
        return toDTO(animalService.update(id, updateAnimal.getName(), updateAnimal.getBinomialName()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        animalService.delete(id);
    }

    private AnimalDTO toDTO(AnimalEntity animalEntity) {
        return new AnimalDTO(
                animalEntity.getId(),
                animalEntity.getName(),
                animalEntity.getBinomialName(),
                animalEntity.getDescription(),
                animalEntity.getConservationStatus()
        );
    }
}
