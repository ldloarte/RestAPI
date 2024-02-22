package com.demo.apirestful.RestAPI.Entity;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhonesController {

    @Autowired
    private PhonesService serviceR;

    @GetMapping
    public List<Phones> listarTodo(){
        return  serviceR.getAllPhones();
    }

    @PostMapping
    public Phones crear(@RequestBody Phones phones){
        return serviceR.createPhones(phones);
    }

    @PostMapping("editar/{id}")
    public Phones actualizar(@RequestBody Phones phones, @PathVariable Long id){
        phones.setId(id);
        return serviceR.updatePhones(phones);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        serviceR.deletePhones(id);
    }
}