package com.example.DogRestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.DogRestApi.entity.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select dog.id, dog.breed from Dog dog where dog.id=:id")
    String findBreedById(Long id);

    @Query("select dog.id, dog.breed from Dog dog")
    List<String> findAllBreed();

    @Query("select dog.id, dog.name from Dog dog")
    List<String> findAllName();
}
