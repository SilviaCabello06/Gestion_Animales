package com.silvia.animales.controllers;

import com.silvia.animales.models.Animal;
import com.silvia.animales.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("titulo", "Nuevo Animal");
        model.addAttribute("animal", new Animal());
        return "animals/formulario";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Animal animal, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "Nuevo Animal");
            return "animals/formulario";
        }
        service.save(animal);
        return "redirect:/animals";
    }

    @GetMapping("/{id}/edit")
    public String formularioEditar(@PathVariable Integer id, Model model){
        model.addAttribute("titulo", "Editar animal");
        model.addAttribute("animal", service.findById(id));
        return "animals/formularioEditar";
    }
    @PostMapping("/{id}/edit")
    public String editar(@Valid @ModelAttribute Animal animal, @PathVariable Integer id,BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("titulo", "Editar animal");
            return "animals/formularioEditar";
        }
        service.update(id, animal);
        return "redirect:/animals";
    }

    @GetMapping("{id}/delete")
    public String confirmacionELiminar(@PathVariable Integer id, Model model){
        model.addAttribute("titulo", "¿Realmente desea eliminar este animal?");
        model.addAttribute("animal", service.findById(id));
        return "animals/eliminar";
    }
    @PostMapping("{id}/delete")
    public String eliminar(@PathVariable Integer id, Model model){
        service.delete(id);
        return "redirect:/animals";
    }
}
