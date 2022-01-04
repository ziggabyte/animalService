package com.example.animalservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
@AllArgsConstructor
public class AnimalsController {

    AnimalService animalService;

    @GetMapping
    public List<AnimalDTO> all() {
        return animalService.all()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AnimalDTO createAnimal(@RequestBody CreateAnimal createAnimal) {
        return toDTO(animalService.add(createAnimal.getName(), createAnimal.getBinomialName()));
    }

    @GetMapping("/{id}")
    public AnimalDTO get(@PathVariable("id") String id) throws AnimalMissingException {
        return toDTO(animalService.get(id).orElse(null));
    }

    @PutMapping("/{id}")
    public AnimalDTO update(@PathVariable("id") String id, @RequestBody UpdateAnimal updateAnimal)
            throws AnimalMissingException {
        return toDTO(animalService.update(id, updateAnimal.getName(), updateAnimal.getBinomialName()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws AnimalMissingException {
        animalService.delete(id);
    }

    private AnimalDTO toDTO(AnimalEntity animalEntity) {
        return new AnimalDTO(
                animalEntity.getId().toString(),
                animalEntity.getName(),
                animalEntity.getBinomialName(),
                animalEntity.getDescription(),
                animalEntity.getConservationStatus()
        );
    }
}
