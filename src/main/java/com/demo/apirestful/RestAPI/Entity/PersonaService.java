package com.demo.apirestful.RestAPI.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }


    public Persona createPersona(Persona persona){
        return personaRepository.save(persona);
    }


    public Persona updatePersona(Persona persona){
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id){
        personaRepository.deleteById(id);
    }
}
