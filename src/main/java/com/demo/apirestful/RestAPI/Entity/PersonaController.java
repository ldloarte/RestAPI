package com.demo.apirestful.RestAPI.Entity;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService serviceP;

    @RequestMapping("/findAll")
    @GetMapping
    public List<Persona> listarTodo(){
        return serviceP.getAllPersonas();
    }

    @RequestMapping("/create")
    @PostMapping
    public Persona crear(@Valid @RequestBody Persona persona){

        return serviceP.createPersona(persona);
    }

    @PostMapping("update/{id}")
    public Persona actualizar(@RequestBody Persona persona, @PathVariable Long id){
        persona.setId(id);
        return serviceP.updatePersona(persona);
    }

    @DeleteMapping("delete/{id}")
    public void eliminar(@PathVariable Long id){
        serviceP.deletePersona(id);
    }
}

