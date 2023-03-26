package com.example.DogRestApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DogRestApi.entity.Dog;
import com.example.DogRestApi.repository.DogRepository;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public boolean deleteDog(Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        Dog dog = optionalDog.orElseThrow(DogNotFoundException::new);
        dogRepository.delete(dog);
        return true;
    }

    public Dog updateDog(Long id, String name, String breed, String origin) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        Dog dog = optionalDog.orElseThrow(DogNotFoundException::new);
        dog.setName(name);
        dog.setBreed(breed);
        dog.setOrigin(origin);
        dogRepository.save(dog);
        return dog;
    }

    // public Dog addDog(String name, String breed, String origin) {
    //     Dog newDog = new Dog(name, breed, origin);
    //     dogRepository.save(newDog);
    //     return newDog;
    // }

    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }

    public Optional<Dog> getDogById(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        return dog;
    }
}
