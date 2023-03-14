package com.cursojava.practica.controller;


import java.io.IOException;

import javax.management.InvalidAttributeValueException;

import com.cursojava.practica.application.*;
import com.cursojava.practica.dominio.Persona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final IPersonaApplication repository;

    PersonaController(IPersonaApplication repository) throws InvalidAttributeValueException, NumberFormatException, IOException {
      this.repository = repository;
    }

    
    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable String id)
    {
        return repository.getPersona(id);
    }

    @PostMapping("/add")
    public void addPersona(@RequestBody Persona p)
    {
        repository.addPersona(p);
    }

    @GetMapping("/init")
    public void initDB()
    {
       Persona p1 = new Persona("0001", "Juan", 7);
       Persona p2 = new Persona("0002", "Victor", 31);
       Persona p3 = new Persona("0003", "Pepe",17);

       repository.addPersona(p1);
       repository.addPersona(p2);
       repository.addPersona(p3);
    }
}

