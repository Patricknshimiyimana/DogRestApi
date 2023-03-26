package com.example.DogRestApi.service;

import java.util.List;
import com.example.DogRestApi.entity.Dog;

public interface DogService {
    List<Dog> retrieveDogs();

    boolean deleteDog(Long id);

    Dog updateDog(Long id, String name, String breed, String origin);

    // Dog addDog(String name, String breed, String origin);

    Dog addDog(Dog dog);
}
