package com.example.DogRestApi.service;

import java.util.List;
import com.example.DogRestApi.entity.Dog;

public interface DogService {
    List<Dog> retrieveDogs();
}
