package com.example.animalservice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AnimalServiceApplicationTests {

    @Autowired
    AnimalsController animalsController;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        animalRepository.saveAll(List.of(
            new AnimalEntity("Katt", "Litus krafsus", null, null),
            new AnimalEntity("Hund", "Grufsus gläfsus", null, null))
        );
    }

    @AfterEach
    void tearDown() {
        animalRepository.deleteAll();

    }

    @Test
    void all() {
        List<AnimalDTO> animals = animalsController.all();

        assertEquals(2, animals.size());
    }

    @Test
    void name() {
        List<AnimalDTO> animals = webTestClient.get()
                .uri("/api/animals")
                .exchange()
                .returnResult(AnimalDTO.class)
                .getResponseBody()
                .collectList()
                .block();

        assertEquals(2, animals.size());
    }
}
