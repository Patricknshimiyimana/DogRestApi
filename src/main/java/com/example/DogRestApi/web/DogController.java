package com.example.DogRestApi.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DogRestApi.entity.Dog;
import com.example.DogRestApi.service.DogService;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogsList = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogsList, HttpStatus.OK);
    }

    @PutMapping("/dogs/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog dog) {
        dogService.updateDog(id, dog.getName(), dog.getBreed(), dog.getOrigin());
        return new ResponseEntity<Dog>(dog, HttpStatus.OK);
    }

    @DeleteMapping("/dogs/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable Long id) {
        boolean deletedDog = dogService.deleteDog(id);
        if (deletedDog == true) {
            String responseMsg = "Dog with ID " + id + " has been successfully deleted.";
            return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
        } else {
            String responseMsg = "Dog with ID " + id + " not found.";
            return new ResponseEntity<String>(responseMsg, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dogs")
    public ResponseEntity<Dog> addDog(@RequestBody Dog dog) {
        Dog newDog = dogService.addDog(dog);
        return new ResponseEntity<Dog>(newDog, HttpStatus.CREATED);
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Optional<Dog>> getDogById(@PathVariable Long id) {
        Optional<Dog> dog = dogService.getDogById(id);
        return new ResponseEntity<Optional<Dog>>(dog, HttpStatus.OK);
    }

}
