package com.example.DogRestApi.service;

import java.util.List;
import java.util.Optional;

import com.example.DogRestApi.entity.Dog;

public interface DogService {
    List<Dog> retrieveDogs();

    boolean deleteDog(Long id);

    Dog updateDog(Long id, String name, String breed, String origin);

    // Dog addDog(String name, String breed, String origin);

    Dog addDog(Dog dog);

    Optional<Dog> getDogById(Long id);

    List<String> retrieveDogBreed();

    String retrieveDogBreedById(Long id);

    List<String> retrieveDogNames();
}
