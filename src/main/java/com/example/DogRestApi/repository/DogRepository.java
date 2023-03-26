package com.example.DogRestApi.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.DogRestApi.entity.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
