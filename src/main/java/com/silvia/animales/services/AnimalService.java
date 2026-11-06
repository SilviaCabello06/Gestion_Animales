package com.silvia.animales.services;

import com.silvia.animales.models.Animal;
import com.silvia.animales.repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository repo;
    public AnimalService(AnimalRepository repo){
       this.repo=repo;
    }
    public List<Animal> findAll() {
        return repo.findAll();
    }

    public Optional<Animal> findById(Integer id){
        return repo.findById(id);
    }

    public void save(Animal animal) {
        repo.save(animal);
    }

    public void update(Integer id, Animal animal){
        animal.setId(id);
        repo.save(animal);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
