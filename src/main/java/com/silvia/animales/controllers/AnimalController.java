package com.silvia.animales.controllers;

import com.silvia.animales.services.AnimalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    private final AnimalService service;
    public AnimalController(AnimalService service){
        this.service=service;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("animals", service.findAll());
        return "animals/index";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("animal", service.findById(id));
        return "animals/detail";
    }
}
