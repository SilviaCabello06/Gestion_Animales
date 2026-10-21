package com.silvia.animales.services;

import com.silvia.animales.models.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimalService {
    private final List<Animal> animals= new ArrayList<>();

    public AnimalService(){
        animals.add(new Animal(1, "Dodo", 30, true));
        animals.add(new Animal(2, "Tortuga", 100, false));
        animals.add(new Animal(3, "Lince", 15, false));
    }
    public List<Animal> findAll() {
        return animals;
    }
    public Animal findById(Integer id){
        for (Animal animal : animals) {
            if (Objects.equals(animal.getId(), id)) {
                return animal;
            }
        }
        return null;
    }
}
